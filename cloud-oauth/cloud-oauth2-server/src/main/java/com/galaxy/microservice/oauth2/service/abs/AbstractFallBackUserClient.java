package com.galaxy.microservice.oauth2.service.abs;

import com.galaxy.microservice.oauth2.service.UserServiceClient;
import com.galaxy.microservice.user.api.vo.UserVo;
import com.galaxy.microservice.util.entity.ResponseResult;

/**
 * @ClassName： AbstractFallBackUserClient
 * @Description
 * @Author alan qin
 * @Date 2019-05-31
 **/
public abstract class AbstractFallBackUserClient  implements UserServiceClient {
    @Override
    public ResponseResult<UserVo> findByUsername(String username) {
        return null;
    }

}
