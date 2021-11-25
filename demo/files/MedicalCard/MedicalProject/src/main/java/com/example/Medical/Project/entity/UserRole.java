package com.example.Medical.Project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JoinColumn(name = "pat_user_info")
    @OneToOne
    private PatUserInfo patUserInfo;
}
