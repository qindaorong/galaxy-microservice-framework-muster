package com.galaxy.microservice.user.api.service.impl;

import com.galaxy.microservice.user.api.service.RoleServiceClient;
import com.galaxy.microservice.user.api.vo.RoleVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 11:06
 */
@Service
@Slf4j
public class RoleServiceClientImpl implements RoleServiceClient {
    @Override
    public ResponseResult<List<RoleVo>> getRoleByUserId(Integer userId) {
        log.info("调用{}失败","getRoleByUserId");
        return ResponseResult.fail(100,"调用getRoleByUserId失败");
    }
}
