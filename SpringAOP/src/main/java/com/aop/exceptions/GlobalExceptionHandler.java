package com.aop.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserIdNotFoundException.class)
	public String userIdNotFoundException(UserIdNotFoundException ex) {
		return ex.getMessage();
		
	}
}
