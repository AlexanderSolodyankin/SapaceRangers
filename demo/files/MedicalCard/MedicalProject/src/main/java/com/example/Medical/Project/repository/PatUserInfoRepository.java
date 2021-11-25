package com.example.Medical.Project.repository;

import com.example.Medical.Project.entity.PatUserInfo;
import com.example.Medical.Project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatUserInfoRepository extends JpaRepository<PatUserInfo, Long> {
    Optional<PatUserInfo> findByUsername(String username);
}
