package com.galaxy.microservice.rocket.provider.api.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.galaxy.microservice.rocket.provider.api.model.dto.TpcMqMessageDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.util.Date;

/**
 * The class Mq message data.
 *
 * @author alan qin
 */
@TableName("pc_mq_message_data")
@Data
@NoArgsConstructor
public class MqMessageData {
	/**
	 * ID
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 版本号
	 */
	@TableField("version")
	private Integer version;

	/**
	 * 消息key
	 */
	@TableField("message_key")
	private String messageKey;

	/**
	 * topic
	 */
	@TableField("message_topic")
	private String messageTopic;

	/**
	 * tag
	 */
	@TableField("message_tag")
	private String messageTag;

	/**
	 * 消息内容
	 */
	@TableField("message_body")
	private String messageBody;

	/**
	 * 消息类型: 10 - 生产者 ; 20 - 消费者
	 */
	@TableField("message_type")
	private Integer messageType;

	/**
	 * 顺序类型, 0有序 1无序
	 */
	@TableField("order_type")
	private int orderType;

	/**
	 * 消息状态
	 */
	@TableField("status")
	private Integer status;

	/**
	 * 延时级别
	 */
	@TableField("delay_level")
	private int delayLevel;

	/**
	 * 创建人
	 */
	@TableField("creator")
	private String creator;

	/**
	 * 创建人ID
	 */
	@TableField("creator_id")
	private Long creatorId;

	/**
	 * 创建时间
	 */
	@TableField("created_time")
	private Date createdTime;

	/**
	 * 最近操作人
	 */
	@TableField("last_operator")
	private String lastOperator;

	/**
	 * 最后操作人ID
	 */
	@TableField("last_operator_id")
	private Long lastOperatorId;

	/**
	 * 更新时间
	 */
	@TableField("update_tim")
	private Date updateTime;

	/**
	 * 是否删除 -0 未删除 -1 已删除
	 */
	@TableField("yn")
	private Integer yn;

	/**
	 * producer group name
	 */
	private String producerGroup;

	public MqMessageData(final String msgBody, final String topic, final String tag, final String key) {
		this.messageBody = msgBody;
		this.messageTopic = topic;
		this.messageTag = tag;
		this.messageKey = key;
	}

	/**
	 * Gets tpc mq message dto.
	 *
	 * @return the tpc mq message dto
	 */
	@Transient
	public TpcMqMessageDto getTpcMqMessageDto() {
		TpcMqMessageDto tpcMqMessageDto = new TpcMqMessageDto();
		tpcMqMessageDto.setMessageBody(this.messageBody);
		tpcMqMessageDto.setMessageKey(this.messageKey);
		tpcMqMessageDto.setMessageTag(this.messageTag);
		tpcMqMessageDto.setMessageTopic(this.messageTopic);
		tpcMqMessageDto.setMessageType(this.messageType);
		tpcMqMessageDto.setRefNo(this.messageKey);
		tpcMqMessageDto.setDelayLevel(this.delayLevel);
		tpcMqMessageDto.setOrderType(this.orderType);
		tpcMqMessageDto.setProducerGroup(this.producerGroup);
		return tpcMqMessageDto;
	}
}