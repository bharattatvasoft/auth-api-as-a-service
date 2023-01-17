package com.waseel.dawy.utils;

public class ResultResponse {

    public ResultResponse(ResponseMessage responseMessage) {
        setResponseMessage(responseMessage);
    }

    public ResultResponse(String code, String message, String status) {
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

    public void setResponseMessage(ResponseMessage responseMessage) {
        this.code = responseMessage.getCode();
        this.message = responseMessage.getMessage();
        this.status = responseMessage.getStatus();
    }
}
