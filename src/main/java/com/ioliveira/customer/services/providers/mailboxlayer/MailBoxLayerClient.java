package com.ioliveira.customer.services.providers.mailboxlayer;

import com.ioliveira.customer.services.providers.mailboxlayer.responses.ValidationEmailResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${mailboxlayer.name}", url = "${mailboxlayer.url}")
public interface MailBoxLayerClient {

    @GetMapping
    ValidationEmailResponse validate(@RequestParam(value = "email") String email);
}
