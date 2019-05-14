package com.galaxy.microservice.oss.getway.service;

import com.galaxy.microservice.oss.getway.bean.dto.BaseFileDTO;
import com.galaxy.microservice.oss.getway.bean.dto.FileResult;
import com.galaxy.microservice.oss.getway.bean.dto.UploadDTO;
import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;
import com.galaxy.microservice.oss.getway.enums.CloudStorageStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CloudDelegate {

    public FileResult upload(CloudStorageStrategy strategy,UploadDTO<? extends FileParam> uploadFileDTO) {
        return strategy.getStrategy().upload(uploadFileDTO);
    }

    public byte[] download(CloudStorageStrategy strategy,BaseFileDTO<? extends FileParam> downloadDTO) {
        return strategy.getStrategy().download(downloadDTO);
    }

    public boolean remove(CloudStorageStrategy strategy,BaseFileDTO<? extends FileParam> baseFileDTO) {
        return strategy.getStrategy().remove(baseFileDTO);
    }

}
