package com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.excepciones;

import com.prueba.sistemaasistencia.zitheonsoft.serviciousuarios.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<WrapperResponse<String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        WrapperResponse<String> response = new WrapperResponse<>("Error en el formato de la petición", null);
        return response.createResponse(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GeneralServiceException.class)
    public ResponseEntity<WrapperResponse<String>> handleGeneralServiceException(GeneralServiceException e){
        WrapperResponse<String> response = new WrapperResponse<>(e.getMessage(), null);
        return response.createResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<WrapperResponse<String>> handleNoDataFoundException(NoDataFoundException e){
        WrapperResponse<String> response = new WrapperResponse<>(e.getMessage(), null);
        return response.createResponse(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateServiceException.class)
    public ResponseEntity<WrapperResponse<String>> handleValidateServiceException(ValidateServiceException e){
        WrapperResponse<String> response = new WrapperResponse<>(e.getMessage(), null);
        return response.createResponse(HttpStatus.BAD_REQUEST);
    }
}
