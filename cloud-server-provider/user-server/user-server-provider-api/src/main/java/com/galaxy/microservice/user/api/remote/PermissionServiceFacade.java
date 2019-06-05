package com.galaxy.microservice.user.api.remote;

import com.galaxy.microservice.user.api.vo.MenuVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PermissionServiceFacade {
    @GetMapping("permission/getRolePermission/{roleId}")
    ResponseResult<List<MenuVo>> getRolePermission(@PathVariable("roleId") Long roleId);
}
