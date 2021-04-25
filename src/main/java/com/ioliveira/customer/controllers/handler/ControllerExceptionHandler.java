package com.ioliveira.customer.controllers.handler;

import com.ioliveira.customer.exceptions.AddressNotFoundException;
import com.ioliveira.customer.exceptions.CustomerNotFoundException;
import com.ioliveira.customer.exceptions.InvalidEmailException;
import com.ioliveira.customer.exceptions.MinimumRegisteredAddressesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StandardError> customerNotFound(final CustomerNotFoundException exception, final HttpServletRequest request) {

        final int status = HttpStatus.NOT_FOUND.value();

        final StandardError error = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .error("Customer not found")
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler
    public ResponseEntity<StandardError> addressNotFound(final AddressNotFoundException exception, final HttpServletRequest request) {

        final int status = HttpStatus.NOT_FOUND.value();

        final StandardError error = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .error("Address not found")
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler
    public ResponseEntity<StandardError> minimumRegisteredAddresses(final MinimumRegisteredAddressesException exception, final HttpServletRequest request) {

        final int status = HttpStatus.PRECONDITION_FAILED.value();

        final StandardError error = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .error("Minimum Registered Addresses")
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler
    public ResponseEntity<StandardError> invalidEmail(final InvalidEmailException exception, final HttpServletRequest request) {

        final int status = HttpStatus.PRECONDITION_FAILED.value();

        final StandardError error = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .error("Email does not exist")
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> controllerValidation(final MethodArgumentNotValidException exception, final HttpServletRequest request) {
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        final ValidationError validationError = ValidationError.builder()
                .timestamp(LocalDateTime.now())
                .status(httpStatus.value())
                .error("Validation error")
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .build();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error -> validationError.addError(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.status(httpStatus).body(validationError);
    }
}
