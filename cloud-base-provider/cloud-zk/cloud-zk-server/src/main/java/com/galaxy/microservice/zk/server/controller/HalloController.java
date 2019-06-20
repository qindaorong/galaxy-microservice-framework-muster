package com.galaxy.microservice.zk.server.controller;

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

    @GetMapping("/hallo")
    public String hallo() {
        return "hallo this is zk server!" ;
    }
}
