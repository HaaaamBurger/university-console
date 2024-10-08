package com.console.university_console.util.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<String> alreadyExistsExceptionHandler(AlreadyExistsException exception) {
       return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundExceptionHandler(NotFoundException exception) {
        return ResponseEntity.badRequest().body(exception.getCause().getLocalizedMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> dataIntegrityViolationExceptionHandler(DataIntegrityViolationException exception) {
        return ResponseEntity.badRequest().body("This entity is already exists.");
    }



    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException exception) {
        return ResponseEntity.badRequest().body("Something went wrong with request reading.");
    }

    @ExceptionHandler(EnumNotMatchingException.class)
    public ResponseEntity<String> enumNotMatchingExceptionHandler(EnumNotMatchingException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}

