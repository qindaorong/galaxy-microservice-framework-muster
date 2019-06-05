package com.galaxy.microservice.oauth2.service;


import com.galaxy.microservice.oauth2.service.impl.PermissionServiceClientImpl;
import com.galaxy.microservice.user.api.remote.PermissionServiceFacade;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "cloud-user-server",fallback = PermissionServiceClientImpl.class)
public interface PermissionServiceClient extends PermissionServiceFacade {

}
