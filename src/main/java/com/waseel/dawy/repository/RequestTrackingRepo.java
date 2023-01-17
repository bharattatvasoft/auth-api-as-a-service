package com.waseel.dawy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.waseel.dawy.entity.RequestTrackingEntity;

@Repository
public interface RequestTrackingRepo extends JpaRepository<RequestTrackingEntity, Long> {

    List<RequestTrackingEntity> findAllBySourceAppIdOrderByIdDesc(String sourceAppId);
}
