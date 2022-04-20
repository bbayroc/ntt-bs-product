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
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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

        product.getAccounttype();
        product.getMovementlimit();

        product.setBalance(product.getBalance() + balanceUpdate.getBalance());
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
