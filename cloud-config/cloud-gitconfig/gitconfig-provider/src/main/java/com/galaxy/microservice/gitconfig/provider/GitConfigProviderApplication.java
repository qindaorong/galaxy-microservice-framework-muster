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
public class GitConfigProviderApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(GitConfigProviderApplication.class)
				.main(GitConfigProviderApplication.class)
				.run(args);
		log.info("----UserServerApplication Start PID={}----", new GitConfigProviderApplication().toString());
		context.registerShutdownHook();
	}
}
