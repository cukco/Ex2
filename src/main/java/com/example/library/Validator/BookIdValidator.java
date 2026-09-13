package com.example.library.Validator;

import com.example.library.Repository.BookRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;


public class BookIdValidator implements ConstraintValidator<ExistingBookId,Long > {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public boolean isValid(Long Id, ConstraintValidatorContext context) {
        if (Id == null) {
            return true;
        }
        return bookRepo.existsById(Math.toIntExact(Id));
    }
}