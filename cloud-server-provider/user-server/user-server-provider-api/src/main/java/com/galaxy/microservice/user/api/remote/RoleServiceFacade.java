package com.galaxy.microservice.user.api.remote;

import com.galaxy.microservice.user.api.vo.RoleVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RoleServiceFacade {
    @GetMapping("role/getRoleByUserId/{userId}")
    ResponseResult<List<RoleVo>> getRoleByUserId(@PathVariable("userId") Integer userId);
}
