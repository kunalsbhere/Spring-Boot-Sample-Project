package com.demo.exception;

import lombok.Data;

@Data
public class UserCustomException extends RuntimeException{

	private String msg;
	private String errorCode;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public UserCustomException(String msg, String errorCode) {
		super();
		this.msg = msg;
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "UserCustomException [msg=" + msg + ", errorCode=" + errorCode + "]";
	}
	
	
}
