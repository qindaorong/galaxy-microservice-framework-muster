package com.galaxy.microservice.oss.aliyun.strategy;

import com.aliyun.oss.model.OSSObject;
import com.galaxy.microservice.oss.aliyun.param.AliDownLoadParam;
import com.galaxy.microservice.oss.getway.bean.dto.BaseFileDTO;
import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;
import com.galaxy.microservice.oss.getway.factory.FileDownload;
import org.springframework.util.Assert;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AliYunDownload extends AbstractAliStrategy implements FileDownload {

    private static final String FAIL_SUPPORT = "BaseFileDTO<T> type is not support";

    @Override
    protected Boolean support(FileParam param) {
        if(param instanceof AliDownLoadParam){
            loadConfiguration();
            return true;
        }
        return false;
    }
    
    @Override
    public byte[] download(BaseFileDTO downloadDTO) {

        Boolean isSupport = this.support(downloadDTO.getParam());
        Assert.isTrue(isSupport,AliYunDownload.FAIL_SUPPORT);

        try {
            AliDownLoadParam aliDownLoadParam = (AliDownLoadParam)downloadDTO.getParam();

            OSSObject ossObject= ossClient.getObject(super.aliConfig.getBucketName(),aliDownLoadParam.getDownloadFilePath());
            return this.input2byte(ossObject.getObjectContent());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            ossClient.shutdown();
        }
        return new byte[0];
    }


    private byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }

    private AliYunDownload(){
        if(LazyHolder.LAZY != null){
            throw new RuntimeException(" AliYunDownload can not have multiple instance");
        }
    }

    public static final AliYunDownload getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final AliYunDownload LAZY = new AliYunDownload();
    }
}
