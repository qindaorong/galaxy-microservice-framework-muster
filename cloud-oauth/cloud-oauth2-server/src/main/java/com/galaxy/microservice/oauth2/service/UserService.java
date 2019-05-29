package com.galaxy.microservice.oauth2.service;

import com.galaxy.microservice.oauth2.entity.User;

public interface UserService {

    /**
     * 根据用手机获得用户信息
     * @param mobile
     * @return
     */
    User findByUserMobileCaseInsensitive(String mobile);

}
