package com.ioliveira.customer.controllers.dtos.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatValidation implements ConstraintValidator<DateFormat, String> {
    @Override
    public void initialize(DateFormat constraintAnnotation) {

    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext context) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
