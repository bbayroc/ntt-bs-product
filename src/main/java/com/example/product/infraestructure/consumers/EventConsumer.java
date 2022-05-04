package com.example.product.infraestructure.consumers;

import com.example.product.infraestructure.events.TransactionEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {
    void consume(@Payload TransactionEvent event, Acknowledgment ack);
}
