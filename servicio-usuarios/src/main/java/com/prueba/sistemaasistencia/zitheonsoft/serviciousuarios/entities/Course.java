package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.CourseStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private CourseStatus status;

}
