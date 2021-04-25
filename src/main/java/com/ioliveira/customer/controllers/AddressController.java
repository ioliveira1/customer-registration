package com.ioliveira.customer.controllers;

import com.ioliveira.customer.controllers.dtos.requests.RequestAddressDTO;
import com.ioliveira.customer.services.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Address", tags = {"Address"})
public class AddressController {

    @Autowired
    private AddressService addressService;


    @ApiOperation(value = "Update a customer address", notes = "Update a customer address")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Address updated successfully"),
            @ApiResponse(code = 400, message = "Invalid request params"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @PutMapping("/addresses/{addressId}")
    public ResponseEntity<Void> updateAddress(@PathVariable final Integer addressId,
                                              @Valid @RequestBody RequestAddressDTO addressDTO) {
        addressService.updateAddress(addressId, addressDTO);
        return ResponseEntity.noContent().build();
    }


    @ApiOperation(value = "Delete customer address by ID", notes = "Delete customer address by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Address deleted successfully"),
            @ApiResponse(code = 404, message = "Address not found"),
            @ApiResponse(code = 412, message = "Operation not allowed"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @DeleteMapping("/addresses/{addressId}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable final Integer addressId) {
        addressService.deleteAddressById(addressId);
        return ResponseEntity.noContent().build();
    }
}
