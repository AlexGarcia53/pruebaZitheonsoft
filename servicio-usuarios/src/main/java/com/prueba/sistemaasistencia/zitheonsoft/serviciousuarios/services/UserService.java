package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.services;

import java.util.List;
import java.util.Optional;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.EmergencyContact;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.excepciones.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.dtos.UserDTO;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.User;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.repositories.IUserRepository;

@Service
public class UserService implements IUserService{
    
    @Autowired
    private IUserRepository userRepository;

    @Transactional
    @Override
    public UserDTO create(User user) {
        User createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO(createdUser.getName(), createdUser.getLastname(),
                createdUser.getWorkStatus(), createdUser.getEmail());
        return userDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public UserDTO update(Long id, User newUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoDataFoundException("No se encontró el usuario"));
//        user.setName(newUser.getName());
//        user.setLastname(newUser.getLastname());
//        user.setBirthDate(newUser.getBirthDate());
//        user.setGender(newUser.getGender());
//        user.setCivilStatus(newUser.getCivilStatus());
//        user.setNacionality(newUser.getNacionality());
//        user.setAddress(newUser.getAddress());
//        user.setContactData(newUser.getContactData());
//        user.setLaborData(newUser.getLaborData());
        System.out.println("====================================");
        for(EmergencyContact emergencyContact : newUser.getEmergencyContacts()){
            System.out.println(emergencyContact.getName());
        }
        System.out.println("====================================");
        System.out.println("Antes de actualizar");
        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setName("Emergency Contact 1");
        //user.addEmergencyContact(emergencyContact);
        user.setEmergencyContacts(newUser.getEmergencyContacts());
//        user.setAcademicDegrees(newUser.getAcademicDegrees());
//        user.setLanguages(newUser.getLanguages());
//        user.setCourses(newUser.getCourses());
//        user.setWorkStatus(newUser.getWorkStatus());
//        user.setEmail(newUser.getEmail());
        userRepository.save(user);
        return new UserDTO(user.getName(), user.getLastname(), user.getWorkStatus(), user.getEmail());
    }

    @Transactional
    @Override
    public UserDTO delete(Long id) {
        User userToDelete = userRepository.findById(id).orElseThrow(()->
                new NoDataFoundException("No se encontró el usuario"));
        userRepository.delete(userToDelete);
        return new UserDTO(userToDelete.getName(), userToDelete.getLastname(), userToDelete.getWorkStatus(), userToDelete.getEmail());
    }

    @Transactional
    @Override
    public List<UserDTO> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<UserDTO> userDTOPage = userRepository.findAllDTO(pageable);
        return userDTOPage.getContent();
    }

}
