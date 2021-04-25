package com.ioliveira.customer.controllers.dtos.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

public class PhoneValidation implements ConstraintValidator<Phone, Set<String>> {
    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(Set<String> phones, ConstraintValidatorContext context) {
        return phones
                .stream()
                .allMatch(phone -> phone.length() >= 10 &&
                        phone.length() <= 11 &&
                        phone.trim().matches("[0-9]+"));
    }
}
