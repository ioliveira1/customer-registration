package com.ioliveira.customer.controllers.dtos.validations;

import com.ioliveira.customer.utils.DocumentValidationUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentValidation implements ConstraintValidator<Document, String> {
    @Override
    public void initialize(Document constraintAnnotation) {

    }

    @Override
    public boolean isValid(String document, ConstraintValidatorContext context) {
        return DocumentValidationUtils.isValidCpf(document) || DocumentValidationUtils.isValidCnpj(document);
    }
}
