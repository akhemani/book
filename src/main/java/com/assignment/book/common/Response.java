package com.assignment.book.common;

import lombok.Data;

@Data
public class Response {

	private ResultCode resultCode;
	private Object data;
	private String message;
	
	public Response(ResultCode resultCode, String message) {
		this.resultCode = resultCode;
		this.message = message;
	}
	
	public Response(ResultCode resultCode, Object data, String message) {
		this.resultCode = resultCode;
		this.data = data;
		this.message = message;
	}
}
