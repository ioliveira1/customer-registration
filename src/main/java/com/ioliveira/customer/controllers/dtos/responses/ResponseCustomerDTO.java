package com.ioliveira.customer.controllers.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ioliveira.customer.entities.enums.CustomerKind;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class ResponseCustomerDTO {
    private String name;
    private String email;
    private String document;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private CustomerKind customerKind;
    private List<ResponseAddressDTO> addresses = new ArrayList<>();
    private Set<String> phones = new HashSet<>();
}
