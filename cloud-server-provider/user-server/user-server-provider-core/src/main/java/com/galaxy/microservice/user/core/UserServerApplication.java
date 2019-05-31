package com.galaxy.microservice.user.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class UserServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(UserServerApplication.class)
				.main(UserServerApplication.class)
				.run(args);
		log.info("----UserServerApplication Start PID={}----", new UserServerApplication().toString());
		context.registerShutdownHook();
	}
}
