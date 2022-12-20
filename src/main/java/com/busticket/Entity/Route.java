package com.busticket.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Getter
@Setter
@Document(collection = "Route")
public class Route {
    @MongoId
    private String id;
    @Field(name = "startPoint")
    private String startPoint;
    @Field(name = "endPoint")
    private String endPoint;
    @Field(name = "departureTime")
    private String departureTime;
    @Field(name = "price")
    private float price;
    @Field(name = "availableTicket")
    private int availableTicket;
}
