package com.ecommerce.order.infrastructure;

import com.ecommerce.order.domain.event.OrderEventPublisher;
import com.ecommerce.order.infrastructure.kafka.OrderEventKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEventPublisherImpl implements OrderEventPublisher {

    private final OrderEventKafkaProducer orderEventKafkaProducer;

    @Override
    public void publishOrderCreatedEvent(Long productId, Long orderId, int orderQuantity) {
        String eventMessage = productId.toString()+ "_" + orderId + "_" + orderQuantity;
        this.orderEventKafkaProducer.sendOrderCreatedEvent(eventMessage);
    }
}
