package com.galaxy.microservice.rocket.provider.api.annotation;

import java.lang.annotation.*;


/**
 * 保存消费者消息.
 *
 * @author alan qin
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MqConsumerStore {

	boolean storePreStatus() default true;
}
