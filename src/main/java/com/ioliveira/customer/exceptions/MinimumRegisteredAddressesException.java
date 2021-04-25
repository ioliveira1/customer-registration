package com.ioliveira.customer.exceptions;

public class MinimumRegisteredAddressesException extends RuntimeException {
    public MinimumRegisteredAddressesException() {
        super("Customer has only one registered address. Cannot delete.");
    }
}
