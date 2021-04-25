package com.ioliveira.customer.controllers.converters;

import com.ioliveira.customer.controllers.dtos.responses.ResponseAddressDTO;
import com.ioliveira.customer.entities.Address;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseAddressConverter {

    private ResponseAddressConverter() {
    }

    public static List<ResponseAddressDTO> toDTO(final List<Address> addresses) {
        return addresses.stream()
                .map(address -> ResponseAddressDTO.builder()
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
