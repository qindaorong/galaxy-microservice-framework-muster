package com.galaxy.microservice.oss.aliyun.strategy;

import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.galaxy.microservice.oss.aliyun.param.AliUpLoadParam;
import com.galaxy.microservice.oss.getway.bean.dto.FileResult;
import com.galaxy.microservice.oss.getway.bean.dto.UploadDTO;
import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;
import com.galaxy.microservice.oss.getway.factory.FileUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.UUID;

@Slf4j
public class AliYunUpload extends AbstractAliStrategy implements FileUpload {

    private static final String FAIL_SUPPORT = "UploadDTO<T> type is not support";


    @Override
    protected Boolean support(FileParam param) {
        if (param instanceof AliUpLoadParam) {
            loadConfiguration();
            return true;
        }
        return false;
    }

    @Override
    public FileResult upload(UploadDTO uploadFileDTO) {

        Boolean isSupport = this.support(uploadFileDTO.getParam());
        Assert.isTrue(isSupport, AliYunUpload.FAIL_SUPPORT);

        try {
            AliUpLoadParam aliUpLoadParam = (AliUpLoadParam) uploadFileDTO.getParam();
            BufferedInputStream is = new BufferedInputStream(byte2Input(uploadFileDTO.getFileBytes()));

            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength(is.available());
            meta.setCacheControl("no-cache");
            meta.setHeader("Pragma", "no-cache");
            meta.setContentEncoding("utf-8");
            meta.setContentType(getContentType(uploadFileDTO.getFileName()));

            PutObjectResult putResult = ossClient.putObject(super.aliConfig.getBucketName(), aliUpLoadParam.getUploadFilePath(), is, meta);
            String resultStr = putResult.getETag();
            log.debug("[AliYunUpload] is working! resultStr is {}",resultStr);

            FileResult fileResult = new FileResult();
            fileResult.setId(UUID.randomUUID().toString());
            fileResult.setUrl(resultStr);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return null;
    }


    private String getContentType(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension) || ".png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        return "image/jpeg";
    }

    public static final InputStream byte2Input(byte[] buf) {
        return new ByteArrayInputStream(buf);
    }

    private AliYunUpload() {
        if (AliYunUpload.LazyHolder.LAZY != null) {
            throw new RuntimeException("AliYunUpload can not have multiple instance");
        }
    }

    public static final AliYunUpload getInstance() {
        return AliYunUpload.LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final AliYunUpload LAZY = new AliYunUpload();
    }

}
