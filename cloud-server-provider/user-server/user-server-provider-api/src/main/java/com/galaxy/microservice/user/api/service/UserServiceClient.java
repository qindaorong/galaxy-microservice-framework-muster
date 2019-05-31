package com.galaxy.microservice.user.api.service;


import com.galaxy.microservice.user.api.service.impl.UserServiceClientImpl;
import com.galaxy.microservice.user.api.vo.UserVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "cloud-user-server",fallback = UserServiceClientImpl.class)
public interface UserServiceClient {
    @GetMapping("user/findByUsername/{username}")
    ResponseResult<UserVo> findByUsername(@PathVariable("username") String username);
}
