package com.ioliveira.customer.controllers.converters;

import com.ioliveira.customer.controllers.dtos.responses.ResponseCustomerDTO;
import com.ioliveira.customer.entities.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseCustomerConverter {

    private ResponseCustomerConverter() {
    }

    public static ResponseCustomerDTO toDTO(final Customer customer) {
        return ResponseCustomerDTO.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .document(customer.getDocument())
                .birthDate(customer.getBirthDate())
                .customerKind(customer.getCustomerKind())
                .addresses(ResponseAddressConverter.toDTO(customer.getAddresses()))
                .phones(customer.getPhones())
                .build();
    }

    public static List<ResponseCustomerDTO> listToDTO(final List<Customer> customers) {
        return customers.stream()
                .map(customer -> ResponseCustomerDTO.builder()
                        .name(customer.getName())
                        .email(customer.getEmail())
                        .document(customer.getDocument())
                        .birthDate(customer.getBirthDate())
                        .customerKind(customer.getCustomerKind())
                        .addresses(ResponseAddressConverter.toDTO(customer.getAddresses()))
                        .phones(customer.getPhones())
                        .build()).collect(Collectors.toList());
    }
}
