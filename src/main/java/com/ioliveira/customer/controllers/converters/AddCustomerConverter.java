package com.ioliveira.customer.controllers.converters;

import com.ioliveira.customer.controllers.dtos.requests.RequestAddressDTO;
import com.ioliveira.customer.controllers.dtos.requests.RequestDTO;
import com.ioliveira.customer.entities.Address;
import com.ioliveira.customer.entities.Customer;
import com.ioliveira.customer.entities.enums.CustomerKind;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class AddCustomerConverter {

    private AddCustomerConverter(){}

    public static Customer toCustomer(final RequestDTO requestDTO) {
        return Customer.builder()
                .name(requestDTO.getCustomerDTO().getName())
                .email(requestDTO.getCustomerDTO().getEmail())
                .document(requestDTO.getCustomerDTO().getDocument())
                .birthDate(LocalDate.parse(requestDTO.getCustomerDTO().getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .customerKind(requestDTO.getCustomerDTO().getDocument().length() == 11 ? CustomerKind.PF.getCode() : CustomerKind.PJ.getCode())
                .addresses(toListAddress(requestDTO.getCustomerDTO().getAddressDTO()))
                .phones(requestDTO.getCustomerDTO().getPhones())
                .build();
    }

    private static List<Address> toListAddress(final List<RequestAddressDTO> addressDTO) {
        return addressDTO.stream().map(address -> Address.builder()
                .zipCode(address.getZipCode())
                .street(address.getStreet())
                .number(address.getNumber())
                .complement(address.getComplement())
                .neighborhood(address.getNeighborhood())
                .city(address.getCity())
                .state(address.getState())
                .build()).collect(Collectors.toList());
    }
}
