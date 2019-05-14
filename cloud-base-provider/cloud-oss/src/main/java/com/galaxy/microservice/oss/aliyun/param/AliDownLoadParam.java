package com.galaxy.microservice.oss.aliyun.param;

import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AliDownLoadParam extends FileParam {
	/**
	 * Bucket下的文件的路径名+文件名 如："upload/cake.jpg"
	 */
	private String downloadFilePath;

}
