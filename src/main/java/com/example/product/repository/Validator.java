package com.example.product.repository;

import com.example.product.Service.SequenceGeneratorService;
import com.example.product.entity.AccountType;
import com.example.product.entity.Product;
import com.example.product.entity.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class Validator {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public Product accountvalidator(Product product, AccountType accountType) {

        if (accountType.getMinimumbalance() < product.getBalance() && accountType.isCreditcardrequired()) {

            Product product1 = productRepository.findByIdclient(product.getIdclient());

            if (Objects.equals(product1.getAccounttype(), "Tarjeta de Credito")) {

                return product;

            } else return null;

        } else if (accountType.getMinimumbalance() < product.getBalance())

            return product;

        else return null;
    }

    public Product productvalidator(ProductRequest productRequest) {

        AccountType accountType = accountTypeRepository.findByAccounttypeAndClienttype(productRequest.getAccounttype(), productRequest.getClienttype());

        Product product1 = productRepository.findByIdclient(productRequest.getIdclient());

        if (accountType == null) {
            return null;
        } else if (product1 != null && !Objects.equals(productRequest.getAccounttype(),"VIP") && Objects.equals(productRequest.getClienttype(),"Personal")) {
            return null;
        } else {

            Product product = new Product();
            product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
            product.setIdaccount(productRequest.getIdaccount());
            product.setAccounttype(productRequest.getAccounttype());
            product.setBalance(productRequest.getBalance());
            product.setIdclient(productRequest.getIdclient());
            product.setCurrency(productRequest.getCurrency());
            product.setComission(productRequest.getComission());
            product.setMovementlimit(productRequest.getMovementlimit());
            product.setUniquedayofmovement(productRequest.getUniquedayofmovement());

            return accountvalidator(product, accountType);

        }
    }
}