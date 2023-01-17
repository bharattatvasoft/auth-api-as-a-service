package com.waseel.dawy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.waseel.dawy.utils.ResponseMessage;
import com.waseel.dawy.utils.ResultResponse;
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommonException extends RuntimeException{
	public CommonException(ResponseMessage failedGenerateFd) {
		this.code = failedGenerateFd.getCode();
        this.message = failedGenerateFd.getMessage();
        this.status = failedGenerateFd.getStatus();
}

public CommonException(String code, String message, String status) {
    this.code = code;
    this.message = message;
    this.status = status;
}

public String code;
public String message;
private String status;

public String getStatus() {
    return status;
}

public String getCode() {
    return code;
}

public void setCode(String code) {
    this.code = code;
}

public String getMessage() {
    return message;
}

public void setMessage(String message) {
    this.message = message;
}

public void setResponseMessage(ResultResponse resultResponse) {
    this.code = resultResponse.getCode();
    this.message = resultResponse.getMessage();
    this.status = resultResponse.getStatus();
}

}
