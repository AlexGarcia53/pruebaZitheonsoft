package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.entities.User;
import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.services.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
}
