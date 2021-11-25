package com.example.Medical.Project.service.impl;

import com.example.Medical.Project.entity.PatUserInfo;
import com.example.Medical.Project.entity.UserRole;
import com.example.Medical.Project.repository.PatUserInfoRepository;
import com.example.Medical.Project.repository.UserRoleRepository;
import com.example.Medical.Project.service.PatUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatUserInfoServiceImpl implements PatUserInfoService {
    @Autowired
    private PatUserInfoRepository patUserInfoRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<PatUserInfo> getAllPatUsersInfo() {
        return patUserInfoRepository.findAll();
    }

    @Override
    public PatUserInfo save(PatUserInfo patUserInfo) {
        patUserInfoRepository.save(patUserInfo);

        UserRole userRole= new UserRole();
        userRole.setRoleName("PATIENT_ROLE");
        userRole.setPatUserInfo(patUserInfo);
        userRoleRepository.save(userRole);
        return patUserInfo;
    }

    @Override
    public PatUserInfo getById(Long id) {
        return patUserInfoRepository.getById(id);
    }

    @Override
    public PatUserInfo deletePatUserInfo(Long id) {
        PatUserInfo patUserInfoDelete = patUserInfoRepository.getById(id);
        patUserInfoRepository.delete(patUserInfoDelete);
        return patUserInfoDelete;
    }

    @Override
    public PatUserInfo getByPatUserName(String userName) {
        return patUserInfoRepository.findByUsername(userName).orElse(null);
    }

}
