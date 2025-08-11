package com.hcltech.car_purchase_service.exception;

import org.apache.coyote.BadRequestException;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OpenApiResourceNotFoundException.class)
    public ResponseEntity<String>handleResourceNotFound(OpenApiResourceNotFoundException ex){
        return new ResponseEntity<>("from gloable ", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>handleGeneralException(Exception ex){
        return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?>handleBadRequest(BadRequestException ex){
        return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<?>handleUnauthorized(HttpClientErrorException.Unauthorized ex){
        return new ResponseEntity<>(ex,HttpStatus.UNAUTHORIZED);
    }
}
