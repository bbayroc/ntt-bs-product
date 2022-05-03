package com.example.product.Service;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.List;
@Configuration
@EnableScheduling
public class Scheduller {
    @Autowired
    private ProductRepository productRepository;
    @Scheduled(cron = "0 0 1 * * ?")

    public void scheduleTaskUsingCronExpression() {

        List<Product> products = productRepository.findByAccounttype("Cuenta Corriente");

        products.forEach(f -> f.setBalance(f.getBalance() - f.getComission()));
        products.forEach(f -> productRepository.save(f));

    }

}


