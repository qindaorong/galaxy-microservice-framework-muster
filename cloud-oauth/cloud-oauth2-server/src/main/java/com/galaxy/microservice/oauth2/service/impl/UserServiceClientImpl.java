package com.galaxy.microservice.oauth2.service.impl;

import com.galaxy.microservice.oauth2.service.UserServiceClient;
import com.galaxy.microservice.oauth2.service.abs.AbstractFallBackUserClient;
import com.galaxy.microservice.user.api.vo.UserVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 10:56
 */
@Service
@Slf4j
public class UserServiceClientImpl extends AbstractFallBackUserClient {
    @Override
    public ResponseResult<UserVo> findByUsername(String username) {
        log.info("调用{}失败","findByUsername");
        return ResponseResult.fail(100,"调用findByUsername接口失败");
    }
}
