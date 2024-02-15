package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.services;

import java.util.List;
import java.util.Optional;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.dtos.UserDTO;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.User;

public interface IUserService {
    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> update(Long id, User user);

    Optional<User> delete(Long id);

    List<UserDTO> findAll();

}
