package com.galaxy.microservice.rocket.provider.api.exceptions;


import com.galaxy.microservice.util.entity.CodeMessage;

/**
 * 应用异常编码
 *
 * @author
 * @since
 */
public class TcpExceptionCode {


    /**
     * 目标接口参数不能为空
     */
    public static final CodeMessage TAGET_NOT_EXIST = new CodeMessage(109001, "目标接口参数不能为空");
    /**
     * 消息数据不能为空
     */
    public static final CodeMessage MESSAGE_NOT_EMPTY = new CodeMessage(109002, "消息数据不能为空");
    /**
     * 消息KEY不能为空
     */
    public static final CodeMessage KEY_NOT_EMPTY = new CodeMessage(109003, "消息KEY不能为空");
    /**
     * 消息的消费Topic不能为空
     */
    public static final CodeMessage CONSUMER_MESSAGE_NOT_EMPTY = new CodeMessage(109004, "消息的消费Topic不能为空");

    /**
     * 消息PID不能为空
     */
    public static final CodeMessage PID_NOT_EMPTY = new CodeMessage(109005, "消息PID不能为空");

    /**
     * 消息中心接口异常
     */
    public static final CodeMessage SERVICE_EXCEPTION = new CodeMessage(109006, "消息中心接口异常");

    /**
     * 目标接口参数不能为空
     */
    public static final CodeMessage INTERFACE_NOT_EMPTY = new CodeMessage(109007, "目标接口参数不能为空");

    /**
     * 注解使用错误
     */
    public static final CodeMessage ANNOTATION_EXCEPTION = new CodeMessage(109008, "注解使用错误");


}