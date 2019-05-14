package com.galaxy.microservice.oss.aliyun.factoryImpl;

import com.galaxy.microservice.oss.aliyun.strategy.AliYunDownload;
import com.galaxy.microservice.oss.aliyun.strategy.AliYunRemove;
import com.galaxy.microservice.oss.aliyun.strategy.AliYunUpload;
import com.galaxy.microservice.oss.getway.bean.dto.BaseFileDTO;
import com.galaxy.microservice.oss.getway.bean.dto.FileResult;
import com.galaxy.microservice.oss.getway.bean.dto.UploadDTO;
import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;
import com.galaxy.microservice.oss.getway.factory.CloudStorage;

public class AliYunStrategy implements CloudStorage {

    private static AliYunStrategy instance = new AliYunStrategy();

    private AliYunStrategy(){}

    public static AliYunStrategy getInstance(){
        return instance;
    }

    @Override
    public byte[] download(BaseFileDTO<? extends FileParam> downloadDTO) {
        return AliYunDownload.getInstance().download(downloadDTO);
    }

    @Override
    public boolean remove(BaseFileDTO<? extends FileParam> baseFileDTO) {
        return AliYunRemove.getInstance().remove(baseFileDTO);
    }

    @Override
    public FileResult upload(UploadDTO<? extends FileParam> uploadFileDTO) {
        return AliYunUpload.getInstance().upload(uploadFileDTO);
    }
}