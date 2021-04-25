package com.ioliveira.customer.services;

import com.ioliveira.customer.controllers.converters.UpdateCustomerConverter;
import com.ioliveira.customer.controllers.dtos.requests.RequestUpdateCustomerDTO;
import com.ioliveira.customer.entities.Customer;
import com.ioliveira.customer.exceptions.CustomerNotFoundException;
import com.ioliveira.customer.exceptions.InvalidEmailException;
import com.ioliveira.customer.repositories.CustomerRepository;
import com.ioliveira.customer.services.providers.mailboxlayer.MailBoxLayerClient;
import com.ioliveira.customer.services.providers.mailboxlayer.responses.ValidationEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MailBoxLayerClient mailBoxLayerClient;

    public Customer findCustomerById(final Integer customerId) {
        return customerRepository
                .findById(customerId)
                .orElseThrow(CustomerNotFoundException::new);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public void deleteCustomerById(final Integer customerId) {
        findCustomerById(customerId);
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public Customer addCustomer(final Customer customer) {
        validateEmail(customer.getEmail());
        return customerRepository.save(customer);
    }

    @Transactional
    public void updateCustomer(final Integer customerId, final RequestUpdateCustomerDTO updateCustomerDTO) {
        final Customer customerUpdated = UpdateCustomerConverter
                .toCustomer(findCustomerById(customerId), updateCustomerDTO);

        customerRepository.save(customerUpdated);
    }

    private void validateEmail(final String email) {
        final ValidationEmailResponse validate = mailBoxLayerClient.validate(email);
        if (!validate.isFormatValid() || !validate.isSmtpCheck()) {
            throw new InvalidEmailException();
        }
    }
}
