package com.galaxy.microservice.oss;

import com.galaxy.microservice.oss.getway.service.CloudDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudStorageConfigure {

    @Bean
    public CloudDelegate createCloudDelegate() {
        return new CloudDelegate();
    }
}
