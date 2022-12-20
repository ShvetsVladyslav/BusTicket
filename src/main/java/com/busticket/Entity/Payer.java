package com.busticket.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payer {
    private String fullName;
    private float price;

    public Payer(String fullName, float price) {
        this.fullName = fullName;
        this.price = price;
    }
}
