package com.galaxy.microservice.oauth2.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.galaxy.microservice.oauth2.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
