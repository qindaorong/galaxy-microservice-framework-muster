package com.galaxy.microservice.rocket.provider.api;

import com.galaxy.microservice.rocket.provider.api.aspect.MqConsumerStoreAspect;
import com.galaxy.microservice.rocket.provider.api.aspect.MqProducerStoreAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName： RocketProviderApiConfiguration
 * @Description
 * @Author alan qin
 * @Date 2019-06-13
 **/
@Configuration
@ComponentScan("com.galaxy.microservice.rocket.provider.api")
public class RocketProviderApiConfiguration {
    @Bean
    @ConditionalOnExpression("${paascloud.aliyun.rocketMq.reliableMessageConsumer:true}")
    public MqConsumerStoreAspect mqConsumerStoreAspect() {
        return new MqConsumerStoreAspect();
    }

    @Bean
    @ConditionalOnExpression("${paascloud.aliyun.rocketMq.reliableMessageProducer:true}")
    public MqProducerStoreAspect mqProducerStoreAspect() {
        return new MqProducerStoreAspect();
    }
}
