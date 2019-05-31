package com.galaxy.microservice.user.api.exceptions;


import com.galaxy.microservice.util.entity.CodeMessage;

/**
 * 应用异常编码
 *
 * @author
 * @since
 */
public class UserExceptionCode {


    /**
     * 用户不存在
     */
    public static final CodeMessage USER_NOT_EXIST = new CodeMessage(101001, "用户不存在");
}