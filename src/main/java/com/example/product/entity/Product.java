package com.example.product.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Product")
@Data
public class Product {

    @Id
    @Transient
    public static final String SEQUENCE_NAME = "product_sequence";
    private long id;
    @Indexed(unique=true)
    private String idaccount;
    private String accounttype;
    private double balance;
    private String idclient;
    private String currency;
    private double comission;
    private int movementlimit;
    private int uniquedayofmovement;
}
