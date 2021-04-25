package com.ioliveira.customer.exceptions;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException() {
        super("Invalid email");
    }
}
