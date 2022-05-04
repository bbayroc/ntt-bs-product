package com.example.product.infraestructure.consumers;

import com.example.product.infraestructure.events.EventHandler;
import com.example.product.infraestructure.events.TransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class TransactionEventConsumer implements EventConsumer {
    @Autowired
    private EventHandler eventHandler;

    @KafkaListener(topics = "TransferEvent", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(@Payload TransactionEvent event, Acknowledgment ack) {
        this.eventHandler.on(event);
        ack.acknowledge();
    }
}
