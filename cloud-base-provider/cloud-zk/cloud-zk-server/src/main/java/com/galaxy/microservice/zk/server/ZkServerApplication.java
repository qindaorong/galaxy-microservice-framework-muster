package com.galaxy.microservice.zk.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.IOException;

/**
 * @ClassName： ZkServerApplication
 * @Description
 * @Author alan qin
 * @Date 2019-06-19
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ZkServerApplication {
    static Object o = new Object();

    public static void main(String[] args) throws IOException {

        SpringApplication.run(ZkServerApplication.class, args);
    }
}
