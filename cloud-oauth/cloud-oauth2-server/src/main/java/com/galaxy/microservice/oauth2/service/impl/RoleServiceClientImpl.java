package com.galaxy.microservice.oauth2.service.impl;

import com.galaxy.microservice.oauth2.service.abs.AbstractFallBackRoleClient;
import com.galaxy.microservice.user.api.vo.RoleVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class RoleServiceClientImpl extends AbstractFallBackRoleClient {
    @Override
    public ResponseResult<List<RoleVo>> getRoleByUserId(Integer userId) {
        log.info("调用{}失败","getRoleByUserId");
        return ResponseResult.fail(100,"调用getRoleByUserId失败");
    }
}
