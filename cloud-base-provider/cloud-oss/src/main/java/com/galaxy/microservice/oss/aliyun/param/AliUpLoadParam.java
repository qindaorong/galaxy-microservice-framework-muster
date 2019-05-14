package com.galaxy.microservice.oss.aliyun.param;

import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AliUpLoadParam extends FileParam {

	/**
	 * 上传文件目录和（包括文件名） 例如“test/a.jpg”
	 */
	private String uploadFilePath;
}
