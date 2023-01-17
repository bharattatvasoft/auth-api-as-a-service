package com.waseel.dawy.utils;

public class AddResultResponse extends ResultResponse {

    public Object data;

    public AddResultResponse(ResponseMessage responseMessage, Object data) {
        super(responseMessage);
        this.data = data;
    }
}
