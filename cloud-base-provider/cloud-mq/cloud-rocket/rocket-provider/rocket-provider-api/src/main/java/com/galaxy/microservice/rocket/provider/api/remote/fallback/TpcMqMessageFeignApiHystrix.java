package com.galaxy.microservice.rocket.provider.api.remote.fallback;

import com.galaxy.microservice.rocket.provider.api.model.dto.TpcMqMessageDto;
import com.galaxy.microservice.rocket.provider.api.remote.TpcMqMessageFeignApi;
import com.galaxy.microservice.util.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName： MqMessageFeignApiHystrix
 * @Description
 * @Author alan qin
 * @Date 2019-06-12
 **/
@Component
@Slf4j
public class TpcMqMessageFeignApiHystrix implements TpcMqMessageFeignApi {

    @Override
    public ResponseResult saveMessageWaitingConfirm(final TpcMqMessageDto mqMessageDto) {
        log.error("saveMessageWaitingConfirm - 服务降级. mqMessageDto={}", mqMessageDto);
        return null;
    }

    @Override
    public ResponseResult confirmAndSendMessage(final String messageKey) {
        return null;
    }

    @Override
    public ResponseResult saveAndSendMessage(final TpcMqMessageDto mqMessageDto) {
        return null;
    }

    @Override
    public ResponseResult directSendMessage(final TpcMqMessageDto mqMessageDto) {
        return null;
    }

    @Override
    public ResponseResult deleteMessageByMessageKey(final String messageKey) {
        return null;
    }

    @Override
    public ResponseResult confirmReceiveMessage(final String cid, final String messageKey) {
        return null;
    }

    @Override
    public ResponseResult confirmConsumedMessage(final String cid, final String messageKey) {
        return null;
    }
}
