package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.services;

import java.util.Optional;

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

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> update(Long id, User newUser) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User userObtained = userOptional.orElseThrow();

            userObtained.setName(newUser.getName());
            userObtained.setLastname(newUser.getLastname());
            userObtained.setBirthDate(newUser.getBirthDate());
            userObtained.setGender(newUser.getGender());
            userObtained.setCivilStatus(newUser.getCivilStatus());
            userObtained.setNacionality(newUser.getNacionality());
            userObtained.setAddress(newUser.getAddress());
            userObtained.setContactData(newUser.getContactData());
            userObtained.setLaborData(newUser.getLaborData());
            userObtained.setEmergencyContacts(newUser.getEmergencyContacts());
            userObtained.setAcademicDegrees(newUser.getAcademicDegrees());
            userObtained.setLanguages(newUser.getLanguages());
            userObtained.setCourses(newUser.getCourses());
            return Optional.of(userRepository.save(userObtained));
        }
        
        return userOptional;
        
    }

    @Transactional
    @Override
    public Optional<User> delete(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(userObtained -> {
            userRepository.delete(userObtained);
        });
        return userOptional;
    }

}
