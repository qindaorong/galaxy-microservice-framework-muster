package com.galaxy.microservice.user.api.service;


import com.galaxy.microservice.user.api.service.impl.RoleServiceImpl;
import com.galaxy.microservice.user.api.vo.RoleVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:12:30
 * ProjectName:Mirco-Service-Skeleton
 */
@FeignClient(name = "user-core",fallback = RoleServiceImpl.class)
public interface RoleService {
    @GetMapping("role/getRoleByUserId/{userId}")
    ResponseResult<List<RoleVo>> getRoleByUserId(@PathVariable("userId") Integer userId);
}
