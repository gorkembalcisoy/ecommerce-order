package com.ecommerce.order.infrastructure.kafka;

import com.ecommerce.order.application.OrderApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventKafkaConsumer {

    private final OrderApplicationService orderApplicationService;

    @KafkaListener(topics = "${spring.kafka.consumer.product-created-topic}", groupId = "${spring.kafka.group-id}")
    public void listenProductCreatedEvent(String message) {
        this.orderApplicationService.createProduct(message);
    }

    @KafkaListener(topics = "${spring.kafka.consumer.stock-insufficient-topic}", groupId = "${spring.kafka.group-id}")
    public void listenProductStockInsufficientEvent(String message) {
        this.orderApplicationService.cancelOrder(message);
    }

    @KafkaListener(topics = "${spring.kafka.consumer.stock-decreased-topic}", groupId = "${spring.kafka.group-id}")
    public void listenProductStockDecreasedEvent(String message) {
        this.orderApplicationService.completeOrder(message);
    }


}
