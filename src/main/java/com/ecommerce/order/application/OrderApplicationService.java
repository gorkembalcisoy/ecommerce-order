package com.ecommerce.order.application;

import com.ecommerce.order.domain.exception.DomainException;
import com.ecommerce.order.domain.model.Order;
import com.ecommerce.order.domain.model.OrderStatus;
import com.ecommerce.order.domain.repository.OrderRepository;
import com.ecommerce.order.infrastructure.rest.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderApplicationService {

    private final OrderRepository orderRepository;

    public void createOrder(OrderCreateRequest orderCreateRequest) throws DomainException {
        if (!this.orderRepository.isProductExist(orderCreateRequest.getProductId())) {
            throw new RuntimeException(); // TODO fix
        }
        Order order = Order.builder()
                .productId(orderCreateRequest.getProductId())
                .orderQuantity(orderCreateRequest.getOrderQuantity())
                .orderStatus(OrderStatus.WAITING)
                .build();
        order.isValid();
        order.setId(this.orderRepository.save(order));
    }

    public void createProduct(String id) {
        Long productId = Long.parseLong(id);
        this.orderRepository.saveProduct(productId);
    }

    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }
}
