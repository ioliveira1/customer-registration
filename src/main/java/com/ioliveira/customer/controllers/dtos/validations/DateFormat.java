package com.ioliveira.customer.controllers.dtos.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateFormatValidation.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFormat {
    String message() default "Must have a valid birth date value [yyyy-MM-dd]";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
