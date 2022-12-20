package com.busticket.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayCallback {
    private boolean response;
    private String description;
    private String payId;

    public PayCallback(boolean response, String description, String payId) {
        this.response = response;
        this.description = description;
        this.payId = payId;
    }
}
