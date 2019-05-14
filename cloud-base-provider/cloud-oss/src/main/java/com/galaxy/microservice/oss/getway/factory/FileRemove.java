package com.galaxy.microservice.oss.getway.factory;

import com.galaxy.microservice.oss.getway.bean.dto.BaseFileDTO;
import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;

public interface FileRemove {
    /**
     * 删除文件
     * @param baseFileDTO 删除参数
     * @return 处理结果
     */
    boolean remove(BaseFileDTO<? extends FileParam> baseFileDTO);
}
