package com.galaxy.microservice.oauth2.service.abs;

import com.galaxy.microservice.oauth2.service.PermissionServiceClient;
import com.galaxy.microservice.user.api.vo.MenuVo;
import com.galaxy.microservice.user.api.vo.UserVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName： AbstractFallBackUserClient
 * @Description
 * @Author alan qin
 * @Date 2019-05-31
 **/
public abstract class AbstractFallBackPermissionClient implements PermissionServiceClient {
    @Override
    public ResponseResult<List<MenuVo>> getRolePermission(@PathVariable("roleId") Integer roleId){
        return null;
    }
}
