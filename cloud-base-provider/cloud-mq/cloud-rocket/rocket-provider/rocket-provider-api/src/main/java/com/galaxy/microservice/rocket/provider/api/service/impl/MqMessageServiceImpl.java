package com.galaxy.microservice.rocket.provider.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.galaxy.microservice.rocket.provider.api.entity.MqMessageData;
import com.galaxy.microservice.rocket.provider.api.exceptions.TcpExceptionCode;
import com.galaxy.microservice.rocket.provider.api.mapper.MqMessageDataMapper;
import com.galaxy.microservice.rocket.provider.api.model.dto.MessageQueryDto;
import com.galaxy.microservice.rocket.provider.api.model.dto.ShardingContextDto;
import com.galaxy.microservice.rocket.provider.api.model.dto.TpcMqMessageDto;
import com.galaxy.microservice.rocket.provider.api.model.enums.MqMessageTypeEnum;
import com.galaxy.microservice.rocket.provider.api.model.enums.MqSendTypeEnum;
import com.galaxy.microservice.rocket.provider.api.model.enums.MqTagEnum;
import com.galaxy.microservice.rocket.provider.api.model.vo.MqMessageVo;
import com.galaxy.microservice.rocket.provider.api.remote.TpcMqMessageFeignApi;
import com.galaxy.microservice.rocket.provider.api.service.MqMessageService;
import com.galaxy.microservice.util.entity.ResponseResult;
import com.galaxy.microservice.util.exception.BusinessException;
import com.galaxy.microservice.util.exception.CoreExceptionCodes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName： MqMessageServiceImpl
 * @Description
 * @Author alan qin
 * @Date 2019-06-12
 **/
@Slf4j
@Service
public class MqMessageServiceImpl implements MqMessageService {
	@Resource
	private MqMessageDataMapper mqMessageDataMapper;
	@Resource
	private TpcMqMessageFeignApi tpcMqMessageFeignApi;
	@Resource
	private TaskExecutor taskExecutor;

	@Value("${spring.profiles.active}")
	String profile;
	@Value("${spring.application.name}")
	String applicationName;

	@Override
	public void saveMqProducerMessage(MqMessageData mqMessageData) {
		// 校验消息数据
		this.checkMessage(mqMessageData);
		// 先保存消息
		mqMessageData.setMessageType(MqMessageTypeEnum.PRODUCER_MESSAGE.messageType());
		mqMessageDataMapper.insert(mqMessageData);
	}

	private void checkMessage(MqMessageData mqMessageData) {
		if (null == mqMessageData) {
			throw new BusinessException(TcpExceptionCode.MESSAGE_NOT_EMPTY);
		}
		String messageTopic = mqMessageData.getMessageTopic();
		String messageBody = mqMessageData.getMessageBody();
		String messageKey = mqMessageData.getMessageKey();
		String producerGroup = mqMessageData.getProducerGroup();
		if (StringUtils.isEmpty(messageKey)) {
			throw new BusinessException(TcpExceptionCode.KEY_NOT_EMPTY);
		}
		if (StringUtils.isEmpty(messageTopic)) {
			throw new BusinessException(TcpExceptionCode.CONSUMER_MESSAGE_NOT_EMPTY);
		}
		if (StringUtils.isEmpty(messageBody)) {
			throw new BusinessException(TcpExceptionCode.MESSAGE_NOT_EMPTY);
		}

		if (StringUtils.isEmpty(producerGroup)) {
			throw new BusinessException(TcpExceptionCode.PID_NOT_EMPTY, mqMessageData.getMessageKey());
		}
	}

	@Override
	public void confirmAndSendMessage(String messageKey) {
		// 发送确认消息给消息中心
		try {
			ResponseResult responseResult = tpcMqMessageFeignApi.confirmAndSendMessage(messageKey);
			if (responseResult == null) {
				throw new BusinessException(CoreExceptionCodes.SERVICE_NOT_SURVIVAL);
			}
			if (responseResult.checkSuccess()) {
				throw new BusinessException(TcpExceptionCode.SERVICE_EXCEPTION);
			}
			log.info("<== saveMqProducerMessage - 存储并发送消息给消息中心成功. messageKey={}", messageKey);
		} catch (Exception e) {
			log.error("<== saveMqProducerMessage - 存储并发送消息给消息中心失败. messageKey={}", messageKey, e);
		}

	}

	@Override
	public void saveMqConsumerMessage(MqMessageData mqMessageData) {

	}

	@Override
	public void deleteMessageByMessageKey(String messageKey, MqSendTypeEnum type) {
		log.info("删除预发送消息. messageKey={}, type={}", messageKey, type);
		if (type == MqSendTypeEnum.WAIT_CONFIRM) {
			taskExecutor.execute(() -> tpcMqMessageFeignApi.deleteMessageByMessageKey(messageKey));
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void confirmReceiveMessage(String cid, MqMessageData messageData) {
		final String messageKey = messageData.getMessageKey();
		log.info("confirmReceiveMessage - 消费者={}, 确认收到key={}的消息", cid, messageKey);
		// 先保存消息
		messageData.setMessageType(MqMessageTypeEnum.CONSUMER_MESSAGE.messageType());
		mqMessageDataMapper.insert(messageData);

		ResponseResult responseResult = tpcMqMessageFeignApi.confirmReceiveMessage(cid, messageKey);
		log.info("tpcMqMessageFeignApi.confirmReceiveMessage result={}", responseResult);
		if (responseResult == null) {
			throw new BusinessException(CoreExceptionCodes.SERVICE_NOT_SURVIVAL);
		}
		if (responseResult.checkSuccess()) {
			throw new BusinessException(TcpExceptionCode.SERVICE_EXCEPTION);
		}
	}

	@Override
	public void saveAndConfirmFinishMessage(String cid, String messageKey) {
		ResponseResult responseResult = tpcMqMessageFeignApi.confirmConsumedMessage(cid, messageKey);
		log.info("tpcMqMessageFeignApi.confirmReceiveMessage result={}", responseResult);
		if (responseResult == null) {
			throw new BusinessException(CoreExceptionCodes.SERVICE_NOT_SURVIVAL);
		}
		if (responseResult.checkSuccess()) {
			throw new BusinessException(TcpExceptionCode.SERVICE_EXCEPTION);
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteMqMessage(final int shardingTotalCount, final int shardingItem, final String tags) {
		// 分页参数每页5000条
		int pageSize = 1000;
		int messageType;
		if (MqTagEnum.DELETE_PRODUCER_MESSAGE.getTag().equals(tags)) {
			messageType = MqMessageTypeEnum.PRODUCER_MESSAGE.messageType();
		} else {
			messageType = MqMessageTypeEnum.CONSUMER_MESSAGE.messageType();
		}

		int totalCount = mqMessageDataMapper.getBefore7DayTotalCount(shardingTotalCount, shardingItem, messageType);
		if (totalCount == 0) {
			return;
		}
		// 分页参数, 总页数
		int pageNum = (totalCount - 1) / pageSize + 1;

		for (int currentPage = 1; currentPage < pageNum; currentPage++) {
			List<Long> idList = mqMessageDataMapper.getIdListBefore7Day(shardingTotalCount, shardingItem, messageType, currentPage, pageSize);
			mqMessageDataMapper.deleteBatchIds(idList);
		}
	}

	@Override
	public void deleteMessageTopic(final String body, final String tags) {
		ShardingContextDto shardingContextDto = JSON.parseObject(body, ShardingContextDto.class);
		int shardingTotalCount = shardingContextDto.getShardingTotalCount();
		int shardingItem = shardingContextDto.getShardingItem();

		this.deleteMqMessage(shardingTotalCount, shardingItem, tags);
	}

	@Override
	public List<String> queryMessageKeyList(final List<String> messageKeyList) {
		return mqMessageDataMapper.queryMessageKeyList(messageKeyList);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveWaitConfirmMessage(final MqMessageData mqMessageData) {
		this.saveMqProducerMessage(mqMessageData);
		// 发送预发送状态的消息给消息中心
		TpcMqMessageDto tpcMqMessageDto = mqMessageData.getTpcMqMessageDto();
		tpcMqMessageFeignApi.saveMessageWaitingConfirm(tpcMqMessageDto);
		log.info("<== saveWaitConfirmMessage - 存储预发送消息成功. messageKey={}", mqMessageData.getMessageKey());
	}

	@Override
	public void saveAndSendMessage(final MqMessageData mqMessageData) {
		this.saveMqProducerMessage(mqMessageData);
		// 发送预发送状态的消息给消息中心
		TpcMqMessageDto tpcMqMessageDto = mqMessageData.getTpcMqMessageDto();
		tpcMqMessageFeignApi.saveAndSendMessage(tpcMqMessageDto);
		log.info("<== saveAndSendMessage - 保存并送消息成功. messageKey={}", mqMessageData.getMessageKey());
	}

	@Override
	public void directSendMessage(final MqMessageData mqMessageData) {
		// 发送预发送状态的消息给消息中心
		TpcMqMessageDto tpcMqMessageDto = mqMessageData.getTpcMqMessageDto();
		tpcMqMessageFeignApi.directSendMessage(tpcMqMessageDto);
		log.info("<== directSendMessage - 直接送消息成功. messageKey={}", mqMessageData.getMessageKey());
	}

	@Override
	public ResponseResult<PageInfo<MqMessageVo>> queryMessageListWithPage(final MessageQueryDto messageQueryDto) {
		PageHelper.startPage(messageQueryDto.getPageNum(), messageQueryDto.getPageSize());
		List<MqMessageVo> list = mqMessageDataMapper.queryMessageListWithPage(messageQueryDto);

		if (CollectionUtils.isEmpty(list)) {
			list = new ArrayList();
		}
		return new ResponseResult(new PageInfo<>(list));
	}
}
