package com.busticket.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayCallback {
    private boolean response;
    private String description;
    private String payId;
    @JsonProperty("state")
    private String state;

    public PayCallback(boolean response, String description, String payId) {
        this.response = response;
        this.description = description;
        this.payId = payId;
    }
}
