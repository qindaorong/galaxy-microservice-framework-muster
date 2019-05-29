package com.galaxy.microservice.oauth2.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.galaxy.microservice.oauth2.entity.User;
import com.galaxy.microservice.oauth2.mapper.UserMapper;
import com.galaxy.microservice.oauth2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Override
	public User findByUserMobileCaseInsensitive(String mobile) {
		EntityWrapper<User> ew = new EntityWrapper<>();
		ew.where("mobile={0}", mobile);
		return super.selectOne(ew);
	}

}
