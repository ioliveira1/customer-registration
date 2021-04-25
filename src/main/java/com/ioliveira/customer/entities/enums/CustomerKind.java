package com.ioliveira.customer.entities.enums;

import java.util.Arrays;

public enum CustomerKind {

    PF(1, "PF"),
    PJ(2, "PJ");

    private final int code;
    private final String description;

    CustomerKind(final int code, final String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static CustomerKind toEnum(final Integer code) {
        if (code != null) {
            return Arrays.stream(CustomerKind.values())
                    .filter(type -> code.equals(type.getCode()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("DocumentKind code " + code + " not found!"));
        }
        return null;
    }
}
