package com.example.library.Exception;

import com.example.library.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalHandleException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        StringBuilder logMessage = new StringBuilder("Invalid Data: ");
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
            logMessage.append(errorMessage);
        });
        log.error(logMessage.toString());
        return new ApiResponse<>("FAIL","Invalid Data",errors);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<?>  handleException(Exception e) {
        log.error("Error: ",e);
        return new ApiResponse<>("FAIL",e.getMessage(),null);
    }

    @ExceptionHandler(ElementNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleElementNotFound(ElementNotFound e) {
        log.error("Error: ",e);
        return new ApiResponse<>("FAIL",e.getMessage(),null);
    }
}
