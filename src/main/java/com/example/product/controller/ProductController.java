package com.example.product.controller;

import com.example.product.entity.BalanceUpdate;
import com.example.product.entity.Product;
import com.example.product.entity.ProductRequest;
import com.example.product.repository.Validator;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Validator validator;

    @PostMapping
    public Product save(@RequestBody ProductRequest productRequest) throws IOException {
        return productRepository.save(validator.productvalidator(productRequest));
    }

    @GetMapping("/accounttype/{accounttype}")
    public List<Product> find3(@PathVariable String accounttype) {
        return productRepository.findByAccounttype(accounttype);
    }

    @GetMapping("/idclients/{idclient}")
    public Product find2(@PathVariable String idclient) {
        return productRepository.findByIdclient(idclient);
    }

    @GetMapping("/idaccounts/{idaccount}")
    public Product find(@PathVariable String idaccount) {
        return productRepository.findByIdaccount(idaccount);
    }

    @PatchMapping("/balance/{idaccount}")
    public Product patch(@PathVariable String idaccount, @RequestBody BalanceUpdate balanceUpdate) {

        Product product = productRepository.findByIdaccount(idaccount);

        product.setBalance(product.getBalance() + balanceUpdate.getBalance());
        return productRepository.save(product);
    }

    @PatchMapping("/comission/{accounttype}")
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

}