package com.busticket.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "Ticket")
public class Ticket {
    @MongoId
    private String id;
    @Field(name = "route")
    private Route route;
    @Field(name = "state")
    private String state;
    @Field(name = "fullName")
    private String fullName;
    @Field(name = "payId")
    private String payId;
}
