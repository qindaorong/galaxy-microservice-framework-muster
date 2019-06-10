package com.galaxy.microservice.gitconfig.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.cloud.config.server.EnableConfigServer;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class CloudConfigServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(CloudConfigServerApplication.class)
				.main(CloudConfigServerApplication.class)
				.run(args);
		log.info("----UserServerApplication Start PID={}----", new CloudConfigServerApplication().toString());
		context.registerShutdownHook();
	}
}
