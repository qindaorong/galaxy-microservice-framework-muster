package com.galaxy.microservice.oss.getway.factory;


import com.galaxy.microservice.oss.getway.bean.dto.BaseFileDTO;
import com.galaxy.microservice.oss.getway.bean.dto.FileResult;
import com.galaxy.microservice.oss.getway.bean.dto.UploadDTO;
import com.galaxy.microservice.oss.getway.bean.dto.param.FileParam;

/**
 * 文件操作统一入口
 */
public interface CloudStorage {

	/**
	 * 文件上传
	 *
	 * @param uploadFileDTO 文件参数对象
	 * @return 文件ID
	 */
	FileResult upload(UploadDTO<? extends FileParam> uploadFileDTO);

	/**
	 * 文件下载
	 * @param downloadDTO 文件参数对象
	 * @return
	 */
	byte[] download(BaseFileDTO<? extends FileParam> downloadDTO);

	/**
	 * 删除文件
	 * @param baseFileDTO 删除参数
	 * @return 处理结果
	 */
	boolean remove(BaseFileDTO<? extends FileParam> baseFileDTO);

}
