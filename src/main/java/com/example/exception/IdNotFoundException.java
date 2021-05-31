package com.example.exception;

public class IdNotFoundException extends Exception{
	private String msg;
	public IdNotFoundException(String msg) {
		this.msg=msg;
	}
	public String getMessage() {
		return msg;
	}
}
