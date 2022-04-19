package com.example.product.repository;

import com.example.product.entity.AccountType;
import com.example.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends MongoRepository<AccountType, Long> {

    AccountType findByAccounttype(String accounttype);
    AccountType findByAccounttypeAndClienttype(String accounttype, String clienttype);
}
