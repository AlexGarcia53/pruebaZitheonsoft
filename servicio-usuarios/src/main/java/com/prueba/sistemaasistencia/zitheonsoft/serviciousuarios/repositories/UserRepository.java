package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.repositories;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
