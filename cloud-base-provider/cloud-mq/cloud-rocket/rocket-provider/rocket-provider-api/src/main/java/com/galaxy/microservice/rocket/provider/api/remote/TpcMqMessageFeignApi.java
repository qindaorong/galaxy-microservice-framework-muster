package com.galaxy.microservice.rocket.provider.api.remote;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.galaxy.microservice.rocket.provider.api.model.dto.TpcMqMessageDto;
import com.galaxy.microservice.rocket.provider.api.remote.fallback.TpcMqMessageFeignApiHystrix;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The interface Tpc mq message feign api.
 *
 * @author alan qin
 */
@FeignClient(value = "paascloud-provider-tpc", fallback = TpcMqMessageFeignApiHystrix.class)
public interface TpcMqMessageFeignApi {

	/**
	 * 预存储消息.
	 *
	 * @param mqMessageDto the mq message dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/tpc/saveMessageWaitingConfirm")
	ResponseResult saveMessageWaitingConfirm(@RequestBody TpcMqMessageDto mqMessageDto);

	/**
	 * 确认并发送消息.
	 *
	 * @param messageKey the message key
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/tpc/confirmAndSendMessage")
	ResponseResult confirmAndSendMessage(@RequestParam("messageKey") String messageKey);

	/**
	 * 存储并发送消息.
	 *
	 * @param mqMessageDto the mq message dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/tpc/saveAndSendMessage")
	ResponseResult saveAndSendMessage(@RequestBody TpcMqMessageDto mqMessageDto);

	/**
	 * 直接发送消息.
	 *
	 * @param mqMessageDto the mq message dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/tpc/directSendMessage")
	ResponseResult directSendMessage(@RequestBody TpcMqMessageDto mqMessageDto);

	/**
	 * 根据messageKey删除消息记录.
	 *
	 * @param messageKey the message key
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/tpc/deleteMessageByMessageKey")
	ResponseResult deleteMessageByMessageKey(@RequestParam("messageKey") String messageKey);

	/**
	 * Confirm receive message wrapper.
	 *
	 * @param cid        the cid
	 * @param messageKey the message key
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/tpc/confirmReceiveMessage")
	ResponseResult confirmReceiveMessage(@RequestParam("cid") final String cid, @RequestParam("messageKey") final String messageKey);

	/**
	 * Save and confirm finish message wrapper.
	 *
	 * @param cid        the cid
	 * @param messageKey the message key
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/tpc/saveAndConfirmFinishMessage")
	ResponseResult confirmConsumedMessage(@RequestParam("cid") final String cid, @RequestParam("messageKey") final String messageKey);
}
