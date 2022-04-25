package com.example.product.controller;

import com.example.product.Service.SequenceGeneratorService;
import com.example.product.entity.AccountType;
import com.example.product.entity.BalanceUpdate;
import com.example.product.entity.Product;
import com.example.product.entity.ProductRequest;
import com.example.product.repository.AccountTypeRepository;
import com.example.product.repository.Validator;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Validator validator;

    @PostMapping
    public Product save(@RequestBody ProductRequest productRequest) {
        return productRepository.save(validator.productvalidator(productRequest));
    }

    @GetMapping("/Accounttype/{accounttype}")
    public List<Product> find3(@PathVariable String accounttype) {
        return productRepository.findByAccounttype(accounttype);
    }

    @GetMapping("/Idclients/{idclient}")
    public Product find2(@PathVariable String idclient) {
        return productRepository.findByIdclient(idclient);
    }

    @GetMapping("/Idaccounts/{idaccount}")
    public Product find(@PathVariable String idaccount) {
        return productRepository.findByIdaccount(idaccount);
    }

    @PatchMapping("/Balance/{idaccount}")
    public Product patch(@PathVariable String idaccount, @RequestBody BalanceUpdate balanceUpdate) {

        Product product = productRepository.findByIdaccount(idaccount);

        product.getAccounttype();
        product.getMovementlimit();

        product.setBalance(product.getBalance() + balanceUpdate.getBalance());
        return productRepository.save(product);
    }

    @PatchMapping("/Comission/{accounttype}")
    public Product patch2(@PathVariable String accounttype, @RequestBody BalanceUpdate balanceUpdate) {

        List<Product> products = productRepository.findByAccounttype(accounttype);

        products.forEach(f -> f.setBalance(f.getBalance() - balanceUpdate.getBalance()));
        products.forEach(f -> productRepository.save(f));

        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable long id, @RequestBody Product product) {
        return productRepository.save(product);
    }
/*
    @Scheduled(cron = "0-20 17 * * ?")
    public void scheduleTaskUsingCronExpression() {

        BalanceUpdate balanceUpdate = new BalanceUpdate();
        balanceUpdate.setBalance(30.0);
        patch2("Cuenta Corriente", balanceUpdate);
    }
*/
}