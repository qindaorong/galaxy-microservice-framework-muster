package com.galaxy.microservice.oauth2.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.galaxy.microservice.oauth2.entity.Authority;
import com.galaxy.microservice.oauth2.mapper.AuthorityMapper;
import com.galaxy.microservice.oauth2.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityService {

    @Autowired
    AuthorityMapper authorityMapper;

    @Override
    public List<Authority> findAuthorityByUserId(long userId) {
        return authorityMapper.findRoleByUserId(userId);
    }

    @Override
    public List<Authority> findRoleByUserManageId(long usermanageId) {
        return authorityMapper.findRoleByUserManageId(usermanageId);
    }
}
