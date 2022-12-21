package com.busticket.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayCallback {
    @JsonIgnore
    private boolean response;
    @JsonIgnore
    private String description;
    @JsonIgnore
    private String payId;
    @JsonProperty("state")
    private String state;

    public PayCallback() {
    }

    public PayCallback(boolean response, String description, String payId, String state) {
        this.response = response;
        this.description = description;
        this.payId = payId;
        this.state = state;
    }

    public PayCallback(boolean response, String description, String payId) {
        this.response = response;
        this.description = description;
        this.payId = payId;
    }
    @Override
    public String toString() {
        return "PayCallback{" +
                "response=" + response +
                ", description='" + description + '\'' +
                ", payId='" + payId + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
