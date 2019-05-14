package com.galaxy.microservice.oss.getway.common;

import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;

public abstract class AbstractStrategy{

    protected abstract Boolean support(FileParam param);


    protected abstract void loadConfiguration();
}
