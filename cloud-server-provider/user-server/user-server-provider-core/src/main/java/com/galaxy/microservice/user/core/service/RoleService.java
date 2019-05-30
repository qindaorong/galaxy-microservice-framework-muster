package com.galaxy.microservice.user.core.service;

import com.galaxy.microservice.user.core.entity.SysRole;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-05-10
 * Time: 20:26
 */
public interface RoleService {
    List<SysRole> getRoleByUserId(Integer userId);
}
