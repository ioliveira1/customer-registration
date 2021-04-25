package com.ioliveira.customer.controllers.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class RequestAddressDTO {
    @NotBlank(message = "ZipCode cannot be null")
    @Size(min = 8, max = 8, message = "Zipcode must have 8 characters")
    @Pattern(regexp = "^([0-9]*)$", message = "Zipcode must have only numbers")
    private String zipCode;

    @NotBlank(message = "Street cannot be null")
    @Size(max = 80, message = "Street must have less than 80 characters")
    private String street;

    @NotBlank(message = "Number cannot be null")
    @Size(max = 10, message = "Number must have less than 10 characters")
    private String number;

    @Size(max = 20, message = "Complement must have less than 20 characters")
    private String complement;

    @NotBlank(message = "Neighborhood cannot be null")
    @Size(max = 50, message = "Neighborhood must have less than 50 characters")
    private String neighborhood;

    @NotBlank(message = "City cannot be null")
    @Size(max = 30, message = "City must have less than 30 characters")
    private String city;

    @NotBlank(message = "State cannot be null")
    @Size(min = 2, max = 2, message = "State must have 2 characters")
    private String state;
}
