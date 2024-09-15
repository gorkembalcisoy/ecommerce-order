package com.ecommerce.order.infrastructure.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEventKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.producer.order-created-topic}")
    private String orderCreatedTopic;

    public void sendOrderCreatedEvent(String eventMessage) {
        this.kafkaTemplate.send(orderCreatedTopic, eventMessage);
    }
}
