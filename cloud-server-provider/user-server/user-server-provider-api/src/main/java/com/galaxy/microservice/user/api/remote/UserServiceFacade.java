package com.galaxy.microservice.user.api.remote;

import com.galaxy.microservice.user.api.vo.UserVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName： UserServiceFacade
 * @Description
 * @Author alan qin
 * @Date 2019-05-31
 **/
public interface UserServiceFacade {

    @GetMapping("user/findByUsername/{username}")
    ResponseResult<UserVo> findByUsername(@PathVariable("username") String username);
}
