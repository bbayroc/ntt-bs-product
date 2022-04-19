package com.example.product.repository;

import com.example.product.entity.AccountType;
import com.example.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class AccountValidator {
    @Autowired
    private ProductRepository productRepository;

    public Product validator(Product product, AccountType accountType) {


        if (accountType.getMinimumbalance() < product.getBalance() && accountType.isCreditcardrequired()) {

            Product product1 = productRepository.findByIdclient(product.getIdclient());

            if (Objects.equals(product1.getAccounttype(), "Tarjeta de Credito")) {

                return product;

            } else return null;
        }
        else if (accountType.getMinimumbalance() < product.getBalance())

            return product;

        else return null;
    }
}
