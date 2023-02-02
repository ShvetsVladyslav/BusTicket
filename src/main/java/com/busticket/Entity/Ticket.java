package com.busticket.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Getter
@Setter
@Document(collection = "Ticket")
public class Ticket {
    @MongoId
    private String id;
    @Field(name = "routeId")
    private String routeId;
    @Field(name = "payId")
    private String payId;

    public Ticket(String routeId, String payId) {
        this.routeId = routeId;
        this.payId = payId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", routeId='" + routeId + '\'' +
                ", payId='" + payId + '\'' +
                '}';
    }
}
