package com.galaxy.microservice.oauth2.service;

import com.galaxy.microservice.oauth2.entity.Authority;

import java.util.List;

public interface AuthorityService {

    List<Authority> findAuthorityByUserId(long userId);

    List<Authority>  findRoleByUserManageId(long usermanageId);
}
