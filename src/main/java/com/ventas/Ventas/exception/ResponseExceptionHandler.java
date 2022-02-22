package com.ventas.Ventas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionReponse>manejarTodasExcepciones(Exception e){
        ExceptionReponse exceptionReponse = new ExceptionReponse(
                new Date(),
                "Ocurrio un error",
                e.getMessage()
        );
        return new ResponseEntity<>(exceptionReponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}