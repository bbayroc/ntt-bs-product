package com.example.product.infraestructure.events;

public interface EventHandler {
    void on(TransactionEvent event);
}
