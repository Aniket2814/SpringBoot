package com.codingshuttle.springbootwebtutorial.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerResourceNotFound(NoSuchElementException exception)
    {
        return new ResponseEntity<>("Resource Not found", HttpStatus.NOT_FOUND);
    }

}
