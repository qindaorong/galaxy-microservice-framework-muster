package com.galaxy.microservice.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @ClassName： RedisSessionConfig
 * @Description
 * @Author alan qin
 * @Date 2019-05-29
 **/

@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
