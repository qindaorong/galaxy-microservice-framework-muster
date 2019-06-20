package com.galaxy.microservice.zk.client.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient("cloud-zk-server")
public interface IHalloService {

    @GetMapping("/hallo")
    String hallo();
}
