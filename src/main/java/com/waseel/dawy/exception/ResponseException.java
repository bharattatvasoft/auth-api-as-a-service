package com.waseel.dawy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.waseel.dawy.utils.ResponseMessage;
import com.waseel.dawy.utils.ResultResponse;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResponseException extends RuntimeException{

	public ResponseException(ResponseMessage responseMessage) {
		super(responseMessage.getMessage());
		this.responseMessage = responseMessage;
	}

	private ResponseMessage responseMessage;

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	
}
