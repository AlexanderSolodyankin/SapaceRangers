package com.example.Medical.Project.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    private String userInfo;
    private Long isActive;

    private LocalDateTime createDate; // Добавил Санек

    @PrePersist // Дописал Санек
    public void datePrePersist(){
        this.createDate = LocalDateTime.now();
    }

}
