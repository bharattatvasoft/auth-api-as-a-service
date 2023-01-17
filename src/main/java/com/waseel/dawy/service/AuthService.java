package com.waseel.dawy.service;

import com.waseel.dawy.Dto.UserInfoDto;
import com.waseel.dawy.entity.UserInfoEntity;

public interface AuthService {

	public UserInfoEntity getUserFromUsername(String userName);
	
	public UserInfoEntity register(UserInfoDto userInfo);
	
}
