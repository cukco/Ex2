package com.example.library.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class FileValidator implements ConstraintValidator<FileExtension, MultipartFile> {

    private String[] allowedExtensions;

    @Override
    public void initialize(FileExtension constraintAnnotation) {
        this.allowedExtensions = constraintAnnotation.extensions();
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext constraintValidatorContext) {
        if(file==null || file.isEmpty() ){return true;}

        String fileName = file.getOriginalFilename();
        if(fileName==null || fileName.isEmpty()){return false;}

        for(String extension : allowedExtensions){
            if(fileName.toLowerCase().endsWith("."+extension)){return true;}
        }
        return false;

    }
}
