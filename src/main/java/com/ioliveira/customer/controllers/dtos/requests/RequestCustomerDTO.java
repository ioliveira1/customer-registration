package com.ioliveira.customer.controllers.dtos.requests;

import com.ioliveira.customer.controllers.dtos.validations.DateFormat;
import com.ioliveira.customer.controllers.dtos.validations.Document;
import com.ioliveira.customer.controllers.dtos.validations.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class RequestCustomerDTO {
    @NotBlank(message = "Name cannot be null")
    @Size(min = 3, max = 30, message = "Name must contain between 3 and 30 characters")
    @Pattern(regexp = "^([a-zA-Z ]*)$", message = "Name must have only letters")
    private String name;

    @NotBlank(message = "Email cannot be null")
    @Size(max = 50, message = "Email must have less than 50 characters")
    @Email
    private String email;

    @NotBlank(message = "Document cannot be null")
    @Size(min = 11, max = 14, message = "Document must contain between 11 and 14 characters")
    @Document
    private String document;

    @NotBlank(message = "Birth date cannot be null")
    @DateFormat
    private String birthDate;

    @NotEmpty(message = "Phones cannot be null")
    @Phone
    private Set<String> phones = new HashSet<>();

    @NotNull
    @Valid
    private List<RequestAddressDTO> addressDTO;
}