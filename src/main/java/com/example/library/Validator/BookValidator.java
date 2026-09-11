package com.example.library.Validator;

import jakarta.validation.ConstraintValidator;

@ExistingBookId
public interface BookValidator extends ConstraintValidator{

}