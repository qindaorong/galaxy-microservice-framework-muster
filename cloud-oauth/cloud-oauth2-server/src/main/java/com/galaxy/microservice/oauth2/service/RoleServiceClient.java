package com.galaxy.microservice.oauth2.service;


import com.galaxy.microservice.oauth2.service.impl.RoleServiceClientImpl;
import com.galaxy.microservice.user.api.remote.RoleServiceFacade;
import com.galaxy.microservice.user.api.vo.RoleVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:12:30
 * ProjectName:Mirco-Service-Skeleton
 */
@FeignClient(name = "cloud-user-server",fallback = RoleServiceClientImpl.class)
public interface RoleServiceClient extends RoleServiceFacade {

}
