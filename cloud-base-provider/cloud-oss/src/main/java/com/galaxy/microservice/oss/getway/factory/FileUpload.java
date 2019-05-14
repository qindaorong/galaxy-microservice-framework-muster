package com.galaxy.microservice.oss.getway.factory;

import com.galaxy.microservice.oss.getway.bean.dto.FileResult;
import com.galaxy.microservice.oss.getway.bean.dto.UploadDTO;
import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;

public interface FileUpload {
    /**
     * 文件上传
     *
     * @param uploadFileDTO 文件参数对象
     * @return 文件ID
     */
    FileResult upload(UploadDTO<? extends FileParam> uploadFileDTO);
}
