package com.galaxy.microservice.oauth2.exceptions;


import com.galaxy.microservice.util.entity.CodeMessage;

/**
 * 应用异常编码
 *
 * @author
 * @since
 */
public class OauthExceptionCode {


    /**
     * 注销失败
     */
    public static final CodeMessage REVOKE_TOKEN_FAIL = new CodeMessage(110000, "注销失败");
}