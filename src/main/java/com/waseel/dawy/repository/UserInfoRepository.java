package com.waseel.dawy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waseel.dawy.entity.UserInfoEntity;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {
	UserInfoEntity findByUsername(String userName);
}
