package com.galaxy.microservice.user.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.galaxy.microservice.user.core.entity.SysMenu;
import com.galaxy.microservice.user.core.mapper.SysMenuMapper;
import com.galaxy.microservice.user.core.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PermissionServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements PermissionService {
    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public List<SysMenu> getPermissionsByRoleId(Integer roleId) {
        return menuMapper.getPermissionsByRoleId(roleId);
    }
}
