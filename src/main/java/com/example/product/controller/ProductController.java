package com.example.product.controller;

import com.example.product.Service.SequenceGeneratorService;
import com.example.product.entity.AccountType;
import com.example.product.entity.BalanceUpdate;
import com.example.product.entity.Product;
import com.example.product.entity.ProductRequest;
import com.example.product.repository.AccountTypeRepository;
import com.example.product.repository.AccountValidator;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/Products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AccountValidator accountValidator;

    @Autowired
    private AccountTypeRepository accountTypeRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping
    public Product save(@RequestBody ProductRequest productRequest) {

        AccountType accountType = accountTypeRepository.findByAccounttypeAndClienttype(productRequest.getAccounttype(), productRequest.getClienttype());

        Product product1 = productRepository.findByIdclient(productRequest.getIdclient());

        if (accountType == null){
            return null;}
        else if (product1 != null && (Objects.equals(productRequest.getAccounttype(), "PYME") || Objects.equals(productRequest.getClienttype(), "Personal"))){
            return null;}
        else{

            //if (boolean || (boolean2 && boolean3) )

        Product product = new Product();
        product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
        product.setIdaccount(productRequest.getIdaccount());
        product.setAccounttype(productRequest.getAccounttype());
        product.setBalance(productRequest.getBalance());
        product.setIdclient(productRequest.getIdclient());
        product.setCurrency(productRequest.getCurrency());

        return productRepository.save(accountValidator.validator(product, accountType));}
    }

    @GetMapping("/Idclients/{idclient}")
    public Product find2(@PathVariable String idclient) {
        return productRepository.findByIdclient(idclient);
    }
    @GetMapping("/Idaccounts/{idaccount}")
    public Product find(@PathVariable String idaccount) {
        return productRepository.findByIdaccount(idaccount);
    }
    @PatchMapping("/{idaccount}")
    public Product patch(@PathVariable String idaccount, @RequestBody BalanceUpdate balanceUpdate) {

        Product product = productRepository.findByIdaccount(idaccount);
        product.setBalance(balanceUpdate.getBalance());
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable long id, @RequestBody Product product) {
        return productRepository.save(product);
    }

}
