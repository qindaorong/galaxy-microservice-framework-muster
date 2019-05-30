package com.galaxy.microservice.user.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.galaxy.microservice.user.core.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}