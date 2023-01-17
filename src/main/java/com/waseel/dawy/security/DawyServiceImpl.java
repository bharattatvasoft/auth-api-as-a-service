package com.waseel.dawy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.waseel.dawy.entity.UserInfoEntity;
import com.waseel.dawy.repository.UserInfoRepository;
@Component
public class DawyServiceImpl implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) {
		UserInfoEntity userInfo = userInfoRepo.findByUsername(username);
		return UserPrinciple.build(userInfo);
	}
}
