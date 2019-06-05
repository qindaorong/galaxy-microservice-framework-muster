package com.galaxy.microservice.order.api.exceptions;


import com.galaxy.microservice.util.entity.CodeMessage;

/**
 * 应用异常编码
 *
 * @author
 * @since
 */
public class OrderExceptionCode {


    /**
     * 用户不存在
     */
    public static final CodeMessage ORDER_NOT_EXIST = new CodeMessage(102001, "订单不存在");
}