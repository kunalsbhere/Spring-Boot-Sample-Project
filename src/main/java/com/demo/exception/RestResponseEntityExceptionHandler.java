package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.response.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleUserExcetion(UserCustomException exception){
		ErrorResponse response = new ErrorResponse();
		response.setErrorMsg(exception.getMsg());
		response.setErrorCode(exception.getErrorCode());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
