package com.example.Medical.Project.service.impl;

import com.example.Medical.Project.entity.User;
import com.example.Medical.Project.entity.UserRole;
import com.example.Medical.Project.model.UserAuthModel;
import com.example.Medical.Project.repository.UserRepository;
import com.example.Medical.Project.repository.UserRoleRepository;
import com.example.Medical.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService { // добавил Санек весь класс
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User seve(User user) {
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_USER");
        userRole.setUser(user);
        userRoleRepository.save(userRole);
        return user;
    }


    @Override
    public User getById(Long id) {

        return userRepository.getById(id);
    }

    @Override
    public User deleteUser(Long id) {
        User userDelete = userRepository.getById(id);
        userRepository.delete(userDelete);
        return userDelete;
    }

    @Override
    public User getCurrentUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUserName(userName);
    }

    @Override
    public User getByUserName(String userName) {
        return userRepository.findByLogin(userName).orElse(null);
    }

    @Override
    public String getAuthorizerToken(UserAuthModel userAuthModel) {
        User user = userRepository.findByLogin(userAuthModel.getLogin()).orElseThrow(
                () -> new IllegalArgumentException("Неверный логин или пароль"));
        boolean isPasswordMatches = passwordEncoder.matches(userAuthModel.getPassword(), user.getPassword());
        if (!isPasswordMatches) {
                throw new IllegalArgumentException("Неверный Логин или Пароль");
        }
        String userNamePasswordPair = userAuthModel.getLogin() + ": " + userAuthModel.getPassword();
        return "Basic " + new String(Base64.getEncoder().encode(userNamePasswordPair.getBytes()));
    }

}
