package com.example.product.entity;

import lombok.Data;

@Data
public class ProductRequest {

    private String idaccount;
    private String accounttype;
    private double balance;
    private String idclient;
    private String currency;
    private String clienttype;
}
