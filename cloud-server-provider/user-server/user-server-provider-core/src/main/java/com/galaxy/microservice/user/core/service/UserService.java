package com.galaxy.microservice.user.core.service;


import com.galaxy.microservice.user.core.entity.SysUser;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-05-09
 * Time: 9:48
 */
public interface UserService {
    SysUser findByUsername(String username);
}
