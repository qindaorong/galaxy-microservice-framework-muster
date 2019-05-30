package com.galaxy.microservice.user.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.galaxy.microservice.user.core.entity.SysRole;
import com.galaxy.microservice.user.core.mapper.SysRoleMapper;
import com.galaxy.microservice.user.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements RoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public List<SysRole> getRoleByUserId(Integer userId) {
        return roleMapper.getRoleByUserId(userId);
    }
}
