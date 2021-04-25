package com.ioliveira.customer.controllers.dtos.requests;

import com.ioliveira.customer.controllers.dtos.validations.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class RequestUpdateCustomerDTO {
    @Email
    @Size(max = 50, message = "Email must have less than 50 characters")
    private String email;

    @Phone
    private Set<String> phones = new HashSet<>();
}