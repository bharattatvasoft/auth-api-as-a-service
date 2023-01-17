package com.waseel.dawy.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waseel.dawy.Dto.UserInfoDto;
import com.waseel.dawy.entity.UserInfoEntity;
import com.waseel.dawy.repository.UserInfoRepository;
import com.waseel.dawy.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	UserInfoRepository userInfoRepo;
	
	@Autowired
	ModelMapper modelMapper;
	@Override
	public UserInfoEntity getUserFromUsername(String userName) {
		return userInfoRepo.findByUsername(userName);
	}

	@Override
	public UserInfoEntity register(UserInfoDto userInfo) {
		UserInfoEntity userInfoBo=modelMapper.map(userInfo, UserInfoEntity.class);
		userInfoRepo.save(userInfoBo);
		return userInfoBo;
	}

}
