package com.waseel.dawy.Dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
@Data
public class JwtRequestModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2636936156391265891L;
    @NotBlank(message = "username should not be empty or missing.")
    private String username;
    @NotBlank(message = "password should not be empty or missing.")
    private String password;


}
