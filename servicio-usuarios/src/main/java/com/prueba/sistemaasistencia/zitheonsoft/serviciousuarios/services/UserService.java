package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.User;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.repositories.IUserRepository;

@Service
public class UserService implements IUserService{
    
    @Autowired
    private IUserRepository userRepository;

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
