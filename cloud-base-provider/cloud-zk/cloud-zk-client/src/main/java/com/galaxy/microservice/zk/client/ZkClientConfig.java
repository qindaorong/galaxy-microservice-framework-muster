package com.galaxy.microservice.zk.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName： ZkClientConfig
 * @Description
 * @Author alan qin
 * @Date 2019-06-19
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ZkClientConfig {
    public static void main(String[] args) {
        SpringApplication.run(ZkClientConfig.class, args);
    }
}
