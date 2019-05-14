package com.galaxy.microservice.oss.getway.bean.dto;

import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;
import lombok.Data;

/**
 * 基本对象
 * @param <T> 存在差异参数
 */
@Data
public class BaseFileDTO<T extends FileParam> {
	/**
	 * 文件ID
	 */
	private String id;
	/**
	 * 不同底层，不同的参数对象
	 */
	private T param;
	
}
