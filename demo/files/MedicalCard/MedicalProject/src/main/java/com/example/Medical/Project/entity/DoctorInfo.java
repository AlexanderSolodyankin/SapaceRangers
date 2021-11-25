package com.example.Medical.Project.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "DoctorInfo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DoctorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "doctor_name", nullable = false)
    private String name;

    @Column(name = "ser_name", nullable = false)
    private String serName;

    @Column(name = "patron_name", nullable = false)
    private String patronName;

    @Column(name = "doc_specialization", nullable = false)
    private String specialization;

    @Column(name = "work_experience", nullable = false)
    private String workExperience;

    @Column(name = "doc_phone", nullable = false)
    private Integer telethon;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDateTime dateOfBirth;

    @Column(name = "INN", nullable = false)
    private String INN;

    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;
}
