package com.galaxy.microservice.oss.getway.bean.dto;


import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;
import lombok.Data;

/**
 * 文件上传对象
 *
 * @param <T> 不同存储差异化参数
 */
@Data
public class UploadDTO<T extends FileParam> {

    /**
     * 文件字节数组
     */
    private byte[] fileBytes;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 不同底层，不同的参数对象
     */
    private T param;
}
