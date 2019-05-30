package com.galaxy.microservice.oauth2.controller;

import com.galaxy.microservice.oauth2.exceptions.OauthExceptionCode;
import com.galaxy.microservice.util.entity.CodeMessage;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-12-07
 * Time: 19:17
 */
@RestController
public class LogoutController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @DeleteMapping(value = "/exit")
    public @ResponseBody
    ResponseResult revokeToken(String access_token){
        ResponseResult msg = null;
        if (consumerTokenServices.revokeToken(access_token)){
            new ResponseResult();
        }else {
            new ResponseResult(OauthExceptionCode.REVOKE_TOKEN_FAIL);
        }
        return msg;
    }
}
