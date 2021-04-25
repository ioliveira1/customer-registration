package com.ioliveira.customer.controllers.handler;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@SuperBuilder
public class ValidationError extends StandardError {
    private final List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(final LocalDateTime timestamp, final Integer status,
                           final String error, final String message, final String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(final String fieldName, final String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}