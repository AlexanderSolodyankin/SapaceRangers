package com.example.Medical.Project.service;


import com.example.Medical.Project.entity.User;
import com.example.Medical.Project.model.UserAuthModel;

import java.util.List;

public interface UserService { // Добавил весь интервейс Санек
    List<User> getAllUsers();
    User seve(User user);
    User getById(Long id);
    User deleteUser(Long id);
    User getCurrentUser();
    User getByUserName(String userName);
    String getAuthorizerToken(UserAuthModel userAuthModel);

}
