package com.example.Medical.Project.controller;

import com.example.Medical.Project.entity.PatUserInfo;
import com.example.Medical.Project.entity.User;
import com.example.Medical.Project.model.UserAuthModel;
import com.example.Medical.Project.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/userall")
    public String getAllUsers(Model model){
        Iterable<User> allUser = userService.getAllUsers();
        model.addAttribute("users", allUser);
        model.addAttribute("log", "Не известный пользователь");
        return "users";
    }

    @GetMapping("/newuser")
    public String menuUsers(Model model){
        return "newuser";
    }
    @GetMapping("/loguser")
    public String logUsers(Model model){
        return "loguser";
    }

    @PostMapping("/loguser")// санек
    public String logUser (@RequestParam String login, @RequestParam String password, Model model){
        if((password.isEmpty() || password == null) || (login.isEmpty() || login == null)) {// санек
            model.addAttribute("texterror", "Нельзя оставлять поля пустыми");
            return "loguser";// санек
        }
        UserAuthModel user = UserAuthModel.builder().login(login).password(password).build();// мирлан
        model.addAttribute("log", user.getLogin());
        String write =
        userService.getAuthorizerToken(UserAuthModel.builder().login(login).password(password).build());
        System.out.println(write);
        return "redirect:/userall";
    }

    @PostMapping("/newuser")
    public String newUser(@RequestParam String login, @RequestParam String password, Model model){
        User user = User.builder().login(login).password(password).userInfo("USER").isActive(3L).build();
        if((password.isEmpty() || password == null) || (login.isEmpty() || login == null)) {
            model.addAttribute("texterror", "Нельзя оставлять поля пустыми");
            return "newuser";
        }
        userService.seve(user);
        model.addAttribute("PatUserInfo", new PatUserInfo());
        return "patUserinfo";
    }
}
