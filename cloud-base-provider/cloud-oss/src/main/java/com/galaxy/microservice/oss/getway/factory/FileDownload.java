package com.galaxy.microservice.oss.getway.factory;

import com.galaxy.microservice.oss.getway.bean.dto.BaseFileDTO;
import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;

public interface FileDownload {

    /**
     * 文件下载
     * @param downloadDTO 文件参数对象
     * @return
     */
    byte[] download(BaseFileDTO<? extends FileParam> downloadDTO);
}
