package com.example.product.repository;

import com.example.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

    Product findByIdaccount(String idaccount);
    Product findByIdclient(String idclient);
    List<Product> findByAccounttype(String accounttype);

}
