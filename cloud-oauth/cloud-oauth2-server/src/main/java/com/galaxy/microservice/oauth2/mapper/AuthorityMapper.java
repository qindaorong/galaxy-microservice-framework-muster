package com.galaxy.microservice.oauth2.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.galaxy.microservice.oauth2.entity.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuthorityMapper extends BaseMapper<Authority> {

    List<Authority> findRoleByUserId(long userId);

    List<Authority> findRoleByUserManageId(long usermanageId);
}

