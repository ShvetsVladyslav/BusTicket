package com.busticket.Entity;

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
    @Field(name = "route")
    private Route route;
    @Field(name = "state")
    private String state;
    @Field(name = "fullName")
    private String fullName;
    @Field(name = "payId")
    private String payId;
}
