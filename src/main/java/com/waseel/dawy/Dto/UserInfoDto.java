package com.waseel.dawy.Dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {

	private Long userId;

	private String email;

	private String fullName;

	private String username;

	private String password;

	private String phoneNumber;

	private String nationalId;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDateTime dateOfBirth;
	private String nationality;

	private String roleId;
}
