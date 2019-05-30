package com.galaxy.microservice.user.api.service;


import com.galaxy.microservice.user.api.service.impl.PermissionServiceImpl;
import com.galaxy.microservice.user.api.vo.MenuVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:12:37
 * ProjectName:Mirco-Service-Skeleton
 */
@FeignClient(name = "user-core",fallback = PermissionServiceImpl.class)
public interface PermissionService {
    @GetMapping("permission/getRolePermission/{roleId}")
    ResponseResult<List<MenuVo>> getRolePermission(@PathVariable("roleId") Integer roleId);
}