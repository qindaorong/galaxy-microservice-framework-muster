package com.galaxy.microservice.order.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class OrderServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(OrderServerApplication.class)
				.main(OrderServerApplication.class)
				.run(args);
		log.info("----OrderServerApplication Start PID={}----", new OrderServerApplication().toString());
		context.registerShutdownHook();
	}
}
