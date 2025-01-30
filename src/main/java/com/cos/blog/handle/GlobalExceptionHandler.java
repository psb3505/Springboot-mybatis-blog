package com.cos.blog.handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.vo.ResponseVO;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseVO<String> handleArgumentException(Exception e) {
		return new ResponseVO<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
}
