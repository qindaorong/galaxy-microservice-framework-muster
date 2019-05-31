package com.galaxy.microservice.oauth2.service;

import com.galaxy.microservice.oauth2.service.impl.UserServiceClientImpl;
import com.galaxy.microservice.user.api.remote.UserServiceFacade;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "cloud-user-server",fallback = UserServiceClientImpl.class)
public interface UserServiceClient extends UserServiceFacade {

}
