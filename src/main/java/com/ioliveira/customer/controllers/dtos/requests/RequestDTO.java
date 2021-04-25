package com.ioliveira.customer.controllers.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class RequestDTO {
    @NotNull
    @Valid
    private RequestCustomerDTO customerDTO;
}
