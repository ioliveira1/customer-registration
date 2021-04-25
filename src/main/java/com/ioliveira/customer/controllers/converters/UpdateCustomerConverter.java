package com.ioliveira.customer.controllers.converters;

import com.ioliveira.customer.controllers.dtos.requests.RequestUpdateCustomerDTO;
import com.ioliveira.customer.entities.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

public class UpdateCustomerConverter {

    private UpdateCustomerConverter() {
    }

    public static Customer toCustomer(final Customer customer, final RequestUpdateCustomerDTO updateCustomerDTO) {
        if (!StringUtils.isBlank(updateCustomerDTO.getEmail())) {
            customer.setEmail(updateCustomerDTO.getEmail());
        }
        if (!CollectionUtils.isEmpty(updateCustomerDTO.getPhones())) {
            customer.setPhones(updateCustomerDTO.getPhones());
        }

        return customer;
    }

}
