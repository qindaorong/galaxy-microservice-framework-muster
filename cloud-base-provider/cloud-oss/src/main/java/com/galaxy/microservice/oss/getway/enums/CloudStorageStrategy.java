package com.galaxy.microservice.oss.getway.enums;

import com.galaxy.microservice.oss.aliyun.factoryImpl.AliYunStrategy;
import com.galaxy.microservice.oss.getway.factory.CloudStorage;
import lombok.Getter;

@Getter
public enum CloudStorageStrategy {

    AliYun(AliYunStrategy.getInstance());

    private CloudStorage strategy;

    CloudStorageStrategy(CloudStorage strategy) {
        this.strategy = strategy;
    }
}
