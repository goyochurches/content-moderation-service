package com.user.flag.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FileNotEmptyValidator.FileNotEmptyValidatorImpl.class)
public @interface FileNotEmptyValidator {

    String message() default "File must not be empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class FileNotEmptyValidatorImpl implements ConstraintValidator<FileNotEmptyValidator, MultipartFile> {

        @Override
        public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
            if (file == null || file.isEmpty()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("File must not be empty").addConstraintViolation();
                return false;
            }
            return true;
        }
    }
}