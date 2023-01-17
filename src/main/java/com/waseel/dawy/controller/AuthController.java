package com.waseel.dawy.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waseel.dawy.Dto.JwtRequestModel;
import com.waseel.dawy.Dto.JwtResponseModel;
import com.waseel.dawy.Dto.UserInfoDto;
import com.waseel.dawy.entity.UserInfoEntity;
import com.waseel.dawy.security.TokenManager;
import com.waseel.dawy.service.AuthService;
import com.waseel.dawy.utils.AddResultResponse;
import com.waseel.dawy.utils.ResponseMessage;
import com.waseel.dawy.utils.ResultResponse;

@RestController
@RequestMapping("/auth")
public class AuthController extends AbstractController {

	@Autowired
	private AuthService authService;

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenManager tokenManager;

	@Autowired
	PasswordEncoder passEncode;

	@PostMapping("/login")
	public ResultResponse createToken(@Valid @RequestBody JwtRequestModel request) {

		UserInfoEntity userEntity = authService.getUserFromUsername(request.getUsername());

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		final String jwtToken = tokenManager.generateJwtToken(userEntity);

		return new AddResultResponse(ResponseMessage.SUCCESS,
				new JwtResponseModel(jwtToken, String.valueOf(userEntity.getUserId()), userEntity.getEmail()));

	}
	
	@PostMapping("/register")
	public ResultResponse register(@Valid @RequestBody UserInfoDto userInfo) {
		userInfo.setPassword(passEncode.encode(userInfo.getPassword()));
		UserInfoEntity userInfoBo=  authService.register(userInfo);
		return new ResultResponse(ResponseMessage.SUCCESS);
	}
}
