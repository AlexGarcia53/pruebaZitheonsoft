package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.enums.COURSE_STATUS;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String platform;
    private String length;
    private COURSE_STATUS status;

    public Course() {
    }

    public Course(String name, String platform, String length, COURSE_STATUS status) {
        this.name = name;
        this.platform = platform;
        this.length = length;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public COURSE_STATUS getStatus() {
        return status;
    }

    public void setStatus(COURSE_STATUS status) {
        this.status = status;
    }
}
