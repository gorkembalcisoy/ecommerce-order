package com.ecommerce.order.infrastructure;

import com.ecommerce.order.domain.model.Order;
import com.ecommerce.order.domain.repository.OrderRepository;
import com.ecommerce.order.infrastructure.jpa.OrderJpaEntityRepository;
import com.ecommerce.order.infrastructure.jpa.ProductJpaEntityRepository;
import com.ecommerce.order.infrastructure.jpa.entity.OrderJpaEntity;
import com.ecommerce.order.infrastructure.jpa.entity.OrderStatus;
import com.ecommerce.order.infrastructure.jpa.entity.ProductJpaEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaEntityRepository orderJpaEntityRepository;
    private final ProductJpaEntityRepository productJpaEntityRepository;

    @Override
    public Long save(Order order) {
        OrderJpaEntity orderJpaEntity = OrderJpaEntity.builder()
                .orderQuantity(order.getOrderQuantity())
                .orderStatus(OrderStatus.valueOf(order.getOrderStatus().label))
                .productId(order.getProductId())
                .build();
        this.orderJpaEntityRepository.save(orderJpaEntity);
        return orderJpaEntity.getId();
    }

    @Override
    public void saveProduct(Long productId) {
        this.productJpaEntityRepository.save(new ProductJpaEntity(productId));
    }

    @Override
    public boolean isProductExist(Long productId) {
        return this.productJpaEntityRepository.findById(productId)
                .isPresent();
    }

    @Override
    public List<Order> findAll() {
        return this.orderJpaEntityRepository.findAll()
                .stream()
                .map(orderJpaEntity -> new Order(orderJpaEntity.getId(),
                        orderJpaEntity.getProductId(),
                        orderJpaEntity.getOrderQuantity(),
                        com.ecommerce.order.domain.model.OrderStatus.valueOf(orderJpaEntity.getOrderStatus().label))
                )
                .collect(Collectors.toList());
    }

    @Override
    public Order findById(Long id) {
        OrderJpaEntity orderJpaEntity = this.orderJpaEntityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id " + id));
        return new Order(orderJpaEntity.getId(),
                orderJpaEntity.getProductId(),
                orderJpaEntity.getOrderQuantity(),
                com.ecommerce.order.domain.model.OrderStatus.valueOf(orderJpaEntity.getOrderStatus().label));
    }

    @Override
    public void update(Order order) {
        OrderJpaEntity orderJpaEntity = this.orderJpaEntityRepository.findById(order.getId())
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id " + order.getId()));
        orderJpaEntity.setOrderStatus(OrderStatus.valueOf(order.getOrderStatus().label));
        this.orderJpaEntityRepository.save(orderJpaEntity);
    }
}
