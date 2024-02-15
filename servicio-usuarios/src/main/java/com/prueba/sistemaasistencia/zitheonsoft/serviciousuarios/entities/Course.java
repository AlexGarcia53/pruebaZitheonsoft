package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.CourseStatus;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String platform;
    private String length;
    @Enumerated(EnumType.STRING)
    private CourseStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
