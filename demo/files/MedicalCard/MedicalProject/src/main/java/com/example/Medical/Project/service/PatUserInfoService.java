package com.example.Medical.Project.service;

import com.example.Medical.Project.entity.PatUserInfo;
import com.example.Medical.Project.entity.User;

import java.util.List;

public interface PatUserInfoService {

    List<PatUserInfo> getAllPatUsersInfo();
    PatUserInfo save(PatUserInfo patUserInfo);
    PatUserInfo getById(Long id);
    PatUserInfo deletePatUserInfo(Long id);
    PatUserInfo getByPatUserName(String userName);
}
