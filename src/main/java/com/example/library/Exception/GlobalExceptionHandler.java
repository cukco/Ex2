package com.example.library.Exception;

import com.example.library.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        String errors=ex.getBindingResult().getFieldError().getDefaultMessage().toString();
        return new ApiResponse<>(HttpStatus.BAD_REQUEST+"",errors, LocalDateTime.now());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<String> handleIllegalExceptions(ResourceNotFoundException ex) {
        String errorMessage = ex.getMessage();
        return new ApiResponse<>(HttpStatus.NOT_FOUND+"",errorMessage,LocalDateTime.now());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<String> handleRuntimeException(RuntimeException ex) {
        String errorMessage = ex.getMessage();
        return new ApiResponse<>(HttpStatus.BAD_REQUEST+"",errorMessage,LocalDateTime.now());
    }
}
