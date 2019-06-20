package com.galaxy.microservice.zk.client.controller;

import com.galaxy.microservice.zk.client.server.IHalloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName： HalloController
 * @Description
 * @Author alan qin
 * @Date 2019-06-20
 **/
@RestController
public class HalloController {

    @Autowired
    IHalloService halloService;

    @GetMapping("/hallo")
    public String hallo() {
        return halloService.hallo();
    }
}
