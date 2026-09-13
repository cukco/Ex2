package com.example.library.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FileValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FileExtension {
    String message() default "Invalid file type";
    String[] extensions() default { "png" ,"jpg" , "jpeg"};
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
