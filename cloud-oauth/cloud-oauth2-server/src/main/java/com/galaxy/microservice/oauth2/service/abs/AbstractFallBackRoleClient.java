package com.galaxy.microservice.oauth2.service.abs;

import com.galaxy.microservice.oauth2.service.RoleServiceClient;
import com.galaxy.microservice.oauth2.service.UserServiceClient;
import com.galaxy.microservice.user.api.vo.RoleVo;
import com.galaxy.microservice.user.api.vo.UserVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName： AbstractFallBackUserClient
 * @Description
 * @Author alan qin
 * @Date 2019-05-31
 **/
public abstract class AbstractFallBackRoleClient implements RoleServiceClient {
    @Override
    public ResponseResult<List<RoleVo>> getRoleByUserId(Integer userId){
        return null;
    }
}
