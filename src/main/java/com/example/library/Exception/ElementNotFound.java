package com.example.library.Exception;

public class ElementNotFound extends RuntimeException {
    public ElementNotFound(String message) {
        super(message);
    }
}
