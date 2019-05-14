package com.galaxy.microservice.web.common;

import com.galaxy.microservice.util.entity.ResponseResult;
import com.galaxy.microservice.util.exception.CoreExceptionCodes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class WebResCallback {

    private final WebResCriteria criteria = new WebResCriteria();

    /**
     * 处理逻辑
     *
     * @param criteria 处理结果
     * @param params   请求参数
     */
    public abstract void execute(final WebResCriteria criteria, Object... params);

    /**
     * 发送请求参数
     *
     * @param params 请求参数
     * @return 返回对象
     */
    public final ResponseResult sendRequest(Object... params) {
        ResponseResult<Object> webResInfo = new ResponseResult<>();
        execute(criteria, params);
        webResInfo.setData(criteria.getResult());
        webResInfo.setMeta(CoreExceptionCodes.SUCCESS);
        return webResInfo;
    }
}