package com.galaxy.microservice.user.api.service.impl;

import com.galaxy.microservice.user.api.service.UserService;
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
public class UserServiceImpl implements UserService {
    @Override
    public ResponseResult<UserVo> findByUsername(String username) {
        log.info("调用{}失败","findByUsername");
        return ResponseResult.fail(100,"调用findByUsername接口失败");
    }
}
