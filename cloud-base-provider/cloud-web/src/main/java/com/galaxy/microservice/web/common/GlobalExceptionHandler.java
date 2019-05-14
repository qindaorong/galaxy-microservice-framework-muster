/*
package com.galaxy.framework.web.common;



import com.galaxy.framework.entity.ResponseResult;
import com.galaxy.framework.exception.BusinessException;
import com.galaxy.framework.exception.CoreExceptionCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	*/
/**
	 * 业务异样
	 * @param exption exption
	 * @return ResponseResult
	 *//*

	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	public ResponseResult businessException(BusinessException exption) {
		log.error(exption.getMessage(),exption);
		ResponseResult<Object> error = new ResponseResult<>();
		error.setMeta(CoreExceptionCodes.REQUEST_ERROR);
		error.setData(CoreExceptionCodes.REQUEST_ERROR.getMessage());
		return error;
	}


	*/
/**
	 * 其他异常信息处理
	 * @param exption exption
	 * @return ResponseResult
	 *//*

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseResult globalException(Exception exption) {
		log.error(exption.getMessage(),exption);
		ResponseResult<Object> error = new ResponseResult<>();
		error.setMeta(CoreExceptionCodes.REQUEST_ERROR);
		error.setData(exption.getMessage());
		return error;
	}

	*/
/**
	 * 参数处理异常
	 * @param exption MethodArgumentNotValidException 参数校验异常类
	 * @return ResponseResult
	 *//*

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseResult globalParamException(MethodArgumentNotValidException exption) {
		List<ObjectError> allErrors = exption.getBindingResult().getAllErrors();
		StringBuilder sb = new StringBuilder();
		for(ObjectError error :allErrors){
			if(error instanceof FieldError){
				sb.append(String.format("property[%s],error msg[%s]",((FieldError) error).getField(), error.getDefaultMessage())).append("\n");
			}
		}
		ResponseResult<Object> error = new ResponseResult<>();
		error.setMeta(CoreExceptionCodes.PARAM_IS_ILLEGAL);
		error.setData(sb.toString());
		return error;
	}


}
*/
