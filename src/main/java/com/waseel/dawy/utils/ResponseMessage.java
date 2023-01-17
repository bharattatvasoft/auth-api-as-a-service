package com.waseel.dawy.utils;

public enum ResponseMessage {

    SUCCESS("MwI00", "Success", "Success"),
    ;
    private final String message;

    private final String code;

    private final String status;

    ResponseMessage(String code, String message, String status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
