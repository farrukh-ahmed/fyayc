package com.fyayc.Interview.common;

import com.fyayc.Interview.exceptions.InvalidUserIdException;
import com.fyayc.Interview.exceptions.ProductCodeIsNotUniqueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Response<?>> handleException(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>(
                new Response<>(ex.getMessage(),
                        new Meta(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value())),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidUserIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response<?>>InvalidUserIdExceptionHandler(RuntimeException ex, WebRequest request){

        return new ResponseEntity<>(
                new Response<>("User Id is null or invalid",
                        new Meta("User Id is null or invalid",HttpStatus.BAD_REQUEST.value())),HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Map<String, String>>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(
                new Response<>(errors,
                        new Meta("Model is invalid.",HttpStatus.BAD_REQUEST.value())),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ProductCodeIsNotUniqueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response<?>> handleUniquerProductCodeException(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>(
                new Response<>("Product Code must be unique.",
                        new Meta("Product Code must be unique.",HttpStatus.BAD_REQUEST.value())),HttpStatus.BAD_REQUEST);
    }
}
