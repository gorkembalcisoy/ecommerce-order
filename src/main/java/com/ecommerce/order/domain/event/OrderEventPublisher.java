package com.ecommerce.order.domain.event;

public interface OrderEventPublisher {

    void publishOrderCreatedEvent(Long productId, Long orderId, int orderQuantity);
}
