package com.ioliveira.customer.services.providers.mailboxlayer.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class ValidationEmailResponse {
    @JsonProperty("format_valid")
    private boolean formatValid;
    @JsonProperty("smtp_check")
    private boolean smtpCheck;
}
