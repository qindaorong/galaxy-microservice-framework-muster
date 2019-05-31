package com.galaxy.microservice.oauth2.service;


import com.galaxy.microservice.oauth2.service.impl.PermissionServiceClientImpl;
import com.galaxy.microservice.user.api.remote.PermissionServiceFacade;
import com.galaxy.microservice.user.api.remote.UserServiceFacade;
import com.galaxy.microservice.user.api.vo.MenuVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "cloud-user-server",fallback = PermissionServiceClientImpl.class)
public interface PermissionServiceClient extends PermissionServiceFacade {

}
