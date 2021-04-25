package com.ioliveira.customer.services;

import com.ioliveira.customer.controllers.converters.UpdateAddressConverter;
import com.ioliveira.customer.controllers.dtos.requests.RequestAddressDTO;
import com.ioliveira.customer.entities.Address;
import com.ioliveira.customer.exceptions.AddressNotFoundException;
import com.ioliveira.customer.exceptions.MinimumRegisteredAddressesException;
import com.ioliveira.customer.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerService customerService;

    public List<Address> findAddressByCustomerId(final Integer customerId) {
        customerService.findCustomerById(customerId);
        return addressRepository.findByCustomerId(customerId);
    }

    public Address findAddressById(final Integer addressId) {
        return addressRepository
                .findById(addressId)
                .orElseThrow(AddressNotFoundException::new);
    }

    @Transactional
    public void deleteAddressById(final Integer addressId) {
        final List<Address> customerAddresses = findAddressByCustomerId(findAddressById(addressId).getCustomerId());
        if (customerAddresses.size() > 1) {
            addressRepository.deleteById(addressId);
        } else {
            throw new MinimumRegisteredAddressesException();
        }
    }

    @Transactional
    public void updateAddress(final Integer addressId, final RequestAddressDTO requestAddressDTO) {
        final Address addressUpdated = UpdateAddressConverter
                .toAddress(findAddressById(addressId), requestAddressDTO);

        addressRepository.save(addressUpdated);
    }
}
