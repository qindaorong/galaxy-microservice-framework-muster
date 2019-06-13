package com.galaxy.microservice.rocket.provider.api.model.enums;

public enum MqTopicEnum {
    /**
     * 发送短信.
     */
    SEND_SMS_TOPIC("SEND_SMS_TOPIC", "发送短信"),
    /**
     * 发送邮件.
     */
    SEND_EMAIL_TOPIC("SEND_EMAIL_TOPIC", "发送邮件"),

    /**
     * Tpc topic mq topic enum.
     */
    TPC_TOPIC("TPC_TOPIC", "TPC_TOPIC"),
    /**
     * Opc topic mq topic enum.
     */
    OPC_TOPIC("OPC_TOPIC", "OPC_TOPIC"),
    /**
     * Mdc topic mq topic enum.
     */
    MDC_TOPIC("MDC_TOPIC", "MDC_TOPIC"),;

    MqTopicEnum(String topic, String topicName) {
        this.topic = topic;
        this.topicName = topicName;
    }

    /**
     * The Topic.
     */
    String topic;
    /**
     * The Topic name.
     */
    String topicName;

    /**
     * Gets topic.
     *
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }
}
