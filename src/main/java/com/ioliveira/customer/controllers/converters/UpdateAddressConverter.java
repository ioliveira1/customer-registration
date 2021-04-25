package com.ioliveira.customer.controllers.converters;

import com.ioliveira.customer.controllers.dtos.requests.RequestAddressDTO;
import com.ioliveira.customer.entities.Address;

public class UpdateAddressConverter {

    private UpdateAddressConverter() {
    }

    public static Address toAddress(final Address address, final RequestAddressDTO addressDTO) {
        address.setZipCode(addressDTO.getZipCode());
        address.setStreet(addressDTO.getStreet());
        address.setNumber(addressDTO.getNumber());
        address.setComplement(addressDTO.getComplement());
        address.setNeighborhood(addressDTO.getNeighborhood());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());

        return address;
    }

}
