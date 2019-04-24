package com.example.project.CarSale.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloabalExceptionHandler{

    @Autowired
    ExceptionResponse exceptionResponse;


    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ExceptionResponse> serviceExceptionHandler(ServiceException se){
        exceptionResponse.setErrorCode("Error-001");
        exceptionResponse.setErrorMessage(se.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}