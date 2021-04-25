package com.ioliveira.customer.controllers;

import com.ioliveira.customer.controllers.converters.AddCustomerConverter;
import com.ioliveira.customer.controllers.converters.ResponseAddressConverter;
import com.ioliveira.customer.controllers.converters.ResponseCustomerConverter;
import com.ioliveira.customer.controllers.dtos.requests.RequestDTO;
import com.ioliveira.customer.controllers.dtos.requests.RequestUpdateCustomerDTO;
import com.ioliveira.customer.controllers.dtos.responses.ResponseAddressDTO;
import com.ioliveira.customer.controllers.dtos.responses.ResponseCustomerDTO;
import com.ioliveira.customer.entities.Customer;
import com.ioliveira.customer.services.AddressService;
import com.ioliveira.customer.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Customer", tags = {"Customer"})
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "Get customer by ID", notes = "Get customer by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer found successfully"),
            @ApiResponse(code = 404, message = "Customer not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<ResponseCustomerDTO> findCustomerById(@PathVariable final Integer customerId) {
        final ResponseCustomerDTO customerDTO = ResponseCustomerConverter
                .toDTO(customerService.findCustomerById(customerId));

        return ResponseEntity.ok(customerDTO);
    }


    @ApiOperation(value = "Get all customers", notes = "Get all customers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer found successfully"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping("/customers")
    public ResponseEntity<List<ResponseCustomerDTO>> findAllCustomers() {
        final List<ResponseCustomerDTO> dtoList = ResponseCustomerConverter
                .listToDTO(customerService.findAllCustomers());

        return ResponseEntity.ok(dtoList);
    }


    @ApiOperation(value = "Get addresses by customer ID", notes = "Get addresses by customer ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Address found successfully"),
            @ApiResponse(code = 404, message = "Address not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping("/customers/{customerId}/addresses")
    public ResponseEntity<List<ResponseAddressDTO>> findAddressByCustomerId(@PathVariable final Integer customerId) {
        final List<ResponseAddressDTO> addressDTOS = ResponseAddressConverter
                .toDTO(addressService.findAddressByCustomerId(customerId));

        return ResponseEntity.ok(addressDTOS);
    }


    @ApiOperation(value = "Add a new customer", notes = "Add a new customer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Customer added successfully"),
            @ApiResponse(code = 400, message = "Invalid request params"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @PostMapping("/customers")
    public ResponseEntity<Void> addCustomer(@Valid @RequestBody RequestDTO requestDTO) {
        final Customer customer = customerService.addCustomer(AddCustomerConverter.toCustomer(requestDTO));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{customerId}")
                .buildAndExpand(customer.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @ApiOperation(value = "Update a customer", notes = "Update a customer")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Customer updated successfully"),
            @ApiResponse(code = 400, message = "Invalid request params"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @PatchMapping("/customers/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable final Integer customerId,
                                               @Valid @RequestBody RequestUpdateCustomerDTO updateCustomerDTO) {
        customerService.updateCustomer(customerId, updateCustomerDTO);
        return ResponseEntity.noContent().build();
    }


    @ApiOperation(value = "Delete customer by ID", notes = "Delete customer by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Customer deleted successfully"),
            @ApiResponse(code = 404, message = "Customer not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable final Integer customerId) {
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.noContent().build();
    }
}
