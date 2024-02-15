package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.controllers;

import java.util.List;
import java.util.Optional;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.dtos.UserDTO;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.User;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.services.IUserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<WrapperResponse<UserDTO>> create(@RequestBody User user){
        UserDTO createdUser = userService.create(user);
        WrapperResponse<UserDTO> response = new WrapperResponse<>("Usuario creado exitosamente", createdUser);
        return response.createResponse(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WrapperResponse<UserDTO>> update(@RequestBody User user, @PathVariable Long id) {
        System.out.println("Entro al update controller");
        UserDTO updatedUser = userService.update(id, user);
        WrapperResponse<UserDTO> response = new WrapperResponse<>("Usuario actualizado exitosamente", updatedUser);
        return response.createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<UserDTO>> delete(@PathVariable Long id) {
        UserDTO deletedUser = userService.delete(id);
        WrapperResponse<UserDTO> response = new WrapperResponse<>("Usuario eliminado exitosamente", deletedUser);
        return response.createResponse(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<UserDTO>>> findAll(@PageableDefault(page = 0, size = 10) Pageable pageable){
        List<UserDTO> users = userService.findAll(pageable.getPageNumber(), pageable.getPageSize());
        WrapperResponse<List<UserDTO>> response = new WrapperResponse<>("Usuarios obtenidos", users);
        return response.createResponse(HttpStatus.OK);
    }
}
