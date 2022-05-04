package com.example.product.infraestructure.events;

import com.example.product.Service.SequenceGeneratorService;
import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionEventHandler implements EventHandler{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void on(TransactionEvent event) {
        Product product = new Product();
        product = productRepository.findByIdaccount(event.getIdaccount());
        product.setBalance(event.getBalance().getBalance());

        productRepository.save(product);
    }
}
