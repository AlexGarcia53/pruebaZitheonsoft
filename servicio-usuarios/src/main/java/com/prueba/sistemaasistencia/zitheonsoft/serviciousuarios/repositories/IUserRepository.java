package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.repositories;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.dtos.UserDTO;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.User;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Long> {
    
    @Query("select new com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.dtos.UserDTO(u.name, u.lastname, u.workStatus, u.contactData.personalEmail) from User u")
    Page<UserDTO> findAllDTO(Pageable pageable);
}
