package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ValidateServiceException extends RuntimeException{
    public ValidateServiceException(String message){
        super(message);
    }
}
