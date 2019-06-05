package com.galaxy.microservice.user.core.service;

import com.galaxy.microservice.user.core.entity.SysMenu;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 10:12
 */
public interface PermissionService {
    List<SysMenu> getPermissionsByRoleId(Long roleId);
}
