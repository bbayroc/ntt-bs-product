package com.example.product.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AccountType")
@Data
public class AccountType {

    private String accounttype;
    private String clienttype;
    private double minimumbalance;
    private boolean creditcardrequired;
    private double minimumdailyaverage;

}
