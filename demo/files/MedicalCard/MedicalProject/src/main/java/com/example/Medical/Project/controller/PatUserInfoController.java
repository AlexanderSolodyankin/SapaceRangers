package com.example.Medical.Project.controller;

import com.example.Medical.Project.entity.PatUserInfo;
import com.example.Medical.Project.entity.User;
import com.example.Medical.Project.service.impl.PatUserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/patUserinfo")
public class PatUserInfoController {
    @Autowired
    private PatUserInfoServiceImpl patUserInfoService;

    @GetMapping("/patUserinfo")
    public String getAllPatUsersInfo(Model model){
        model.addAttribute("PatUserInfo", new PatUserInfo());
        return "patUserinfo";
    }
    @PostMapping("/patUserinfo")
    public String setInfo(@ModelAttribute("PatUserInfo") PatUserInfo userInfo, Model model){
        System.out.println(userInfo);

        return "/";
    }
}
