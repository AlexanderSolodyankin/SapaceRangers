package com.example.Medical.Project.repository;


import com.example.Medical.Project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> { // Санек
    Optional<User> findByLogin(String login);

}
