package com.projetointegrador.letsbeautfy.resources.exceptions;

import com.projetointegrador.letsbeautfy.services.exceptions.ObjectnotFoudException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectnotFoudException.class)
    public ResponseEntity<StandardError> objectnotFoudException(ObjectnotFoudException ex, HttpServletRequest request){

        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),"object Not Found", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
