package com.galaxy.microservice.rocket.provider.api.model.enums;

public enum MqTagEnum {
    /**
     * 注册获取验证码.
     */
    REGISTER_USER_AUTH_CODE("REGISTER_USER_AUTH_CODE", MqTopicEnum.SEND_SMS_TOPIC.getTopic(), "注册获取验证码"),
    /**
     * 修改密码获取验证码.
     */
    MODIFY_PASSWORD_AUTH_CODE("MODIFY_PASSWORD_AUTH_CODE", MqTopicEnum.SEND_SMS_TOPIC.getTopic(), "修改密码获取验证码"),
    /**
     * 忘记密码获取验证码.
     */
    FORGOT_PASSWORD_AUTH_CODE("FORGOT_PASSWORD_AUTH_CODE", MqTopicEnum.SEND_EMAIL_TOPIC.getTopic(), "忘记密码获取验证码"),

    /**
     * 激活用户.
     */
    ACTIVE_USER("ACTIVE_USER", MqTopicEnum.SEND_EMAIL_TOPIC.getTopic(), "激活用户"),
    /**
     * 激活用户成功.
     */
    ACTIVE_USER_SUCCESS("ACTIVE_USER_SUCCESS", MqTopicEnum.SEND_EMAIL_TOPIC.getTopic(), "激活用户成功"),
    /**
     * 重置密码
     */
    RESET_LOGIN_PWD("RESET_LOGIN_PWD", MqTopicEnum.SEND_EMAIL_TOPIC.getTopic(), "重置密码"),

    /**
     * 重置密码
     */
    RESET_USER_EMAIL("RESET_LOGIN_PWD", MqTopicEnum.SEND_EMAIL_TOPIC.getTopic(), "重置密码"),

    /**
     * 删除生产者历史消息
     */
    DELETE_PRODUCER_MESSAGE("DELETE_PRODUCER_MESSAGE", MqTopicEnum.TPC_TOPIC.getTopic(), "删除生产者历史消息"),

    /**
     * 删除消费者历史消息
     */
    DELETE_CONSUMER_MESSAGE("DELETE_CONSUMER_MESSAGE", MqTopicEnum.TPC_TOPIC.getTopic(), "删除消费者历史消息"),

    /**
     * 发送异常日志.
     */
    SEND_DINGTALK_MESSAGE("SEND_EXCEPTION_LOG", MqTopicEnum.OPC_TOPIC.getTopic(), "发送异常日志"),

    /**
     * 更新附件信息.
     */
    UPDATE_ATTACHMENT("UPDATE_ATTACHMENT", MqTopicEnum.MDC_TOPIC.getTopic(), "更新附件信息"),
    /**
     * 删除附件信息
     */
    DELETE_ATTACHMENT("DELETE_ATTACHMENT", MqTopicEnum.MDC_TOPIC.getTopic(), "删除附件信息"),;
    /**
     * The Tag.
     */
    String tag;
    /**
     * The Topic.
     */
    String topic;
    /**
     * The Tag name.
     */
    String tagName;

    MqTagEnum(String tag, String topic, String tagName) {
        this.tag = tag;
        this.topic = topic;
        this.tagName = tagName;
    }

    /**
     * Gets tag.
     *
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * Gets topic.
     *
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }
}
