package com.galaxy.microservice.oss.getway.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class CloudStorageConfig {

    @Data
    @Component(value = "aliConfig")
    @ConfigurationProperties(prefix = "cloud-storage.ali")
    public static class AliConfig{
        private String endpoint;
        private String accessKeyId;
        private String accessKeySecret;
        private String bucketName;
        private String folder;
        private String path;
    }
}
