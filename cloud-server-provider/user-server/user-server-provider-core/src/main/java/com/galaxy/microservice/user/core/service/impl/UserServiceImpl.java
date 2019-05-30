package com.galaxy.microservice.user.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.galaxy.microservice.user.core.entity.SysUser;
import com.galaxy.microservice.user.core.mapper.SysUserMapper;
import com.galaxy.microservice.user.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUser findByUsername(String username) {
        EntityWrapper<SysUser> ew = new EntityWrapper<>();
        ew.where("username={0}", username);
        return super.selectOne(ew);
    }
}
