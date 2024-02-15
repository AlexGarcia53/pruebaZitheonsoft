package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.services;

import java.util.List;
import java.util.Optional;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.dtos.UserDTO;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.dtos.UserDataDTO;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.User;

public interface IUserService {
    UserDTO create(User user);

    Optional<User> findById(Long id);

    UserDTO update(Long id, User user);

    UserDTO delete(Long id);

    List<UserDTO> findAll(int pageNumber, int pageSize);

    UserDataDTO findUserData(Long id);
}
