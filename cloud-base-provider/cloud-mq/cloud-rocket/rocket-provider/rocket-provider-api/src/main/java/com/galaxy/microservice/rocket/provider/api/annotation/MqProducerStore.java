package com.galaxy.microservice.rocket.provider.api.annotation;

import com.galaxy.microservice.rocket.provider.api.model.enums.DelayLevelEnum;
import com.galaxy.microservice.rocket.provider.api.model.enums.MqOrderTypeEnum;
import com.galaxy.microservice.rocket.provider.api.model.enums.MqSendTypeEnum;

import java.lang.annotation.*;


/**
 * 保存生产者消息.
 *
 * @author alan qin
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MqProducerStore {
	MqSendTypeEnum sendType() default MqSendTypeEnum.WAIT_CONFIRM;

	MqOrderTypeEnum orderType() default MqOrderTypeEnum.ORDER;

	DelayLevelEnum delayLevel() default DelayLevelEnum.ZERO;
}
