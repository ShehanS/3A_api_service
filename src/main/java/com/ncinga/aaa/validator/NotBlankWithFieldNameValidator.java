package com.ncinga.aaa.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotBlankWithFieldNameValidator implements ConstraintValidator<NotBlankWithFieldName, String> {
    private String fieldName;

    @Override
    public void initialize(NotBlankWithFieldName constraintAnnotation) {
        this.fieldName = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.trim().isEmpty();
    }
}
