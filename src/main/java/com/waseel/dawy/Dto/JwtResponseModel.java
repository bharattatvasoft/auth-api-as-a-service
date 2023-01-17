package com.waseel.dawy.Dto;

import lombok.Data;

@Data
public class JwtResponseModel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final String token;
    private final String partnerId;
    private final String  sourceAppId;

}
