package com.ecommerce.order.infrastructure.kafka;

import com.ecommerce.order.application.OrderApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventKafkaConsumer {

    private final OrderApplicationService orderApplicationService;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.group-id}")
    public void listen(String message) {
        this.orderApplicationService.createProduct(message);
    }
}
