package com.galaxy.microservice.oss.aliyun.strategy;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.galaxy.microservice.oss.getway.common.AbstractStrategy;
import com.galaxy.microservice.oss.getway.common.SpringApplicationContext;
import com.galaxy.microservice.oss.getway.configuration.CloudStorageConfig;

public abstract class AbstractAliStrategy extends AbstractStrategy {

    protected CloudStorageConfig.AliConfig aliConfig;

    protected OSS ossClient= null;

    @Override
    protected void loadConfiguration() {
        //获得配置文件信息
        aliConfig = SpringApplicationContext.getBean(CloudStorageConfig.AliConfig.class);
        ossClient= new OSSClientBuilder().build(aliConfig.getEndpoint(), aliConfig.getAccessKeyId(), aliConfig.getAccessKeySecret());
    }
}
