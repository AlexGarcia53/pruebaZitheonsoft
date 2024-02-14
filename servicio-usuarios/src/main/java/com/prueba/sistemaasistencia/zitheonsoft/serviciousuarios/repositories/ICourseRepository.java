package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.Course;

public interface ICourseRepository extends JpaRepository<Course, Long>{
    
}
