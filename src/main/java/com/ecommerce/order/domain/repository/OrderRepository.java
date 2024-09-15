package com.ecommerce.order.domain.repository;

import com.ecommerce.order.domain.model.Order;

import java.util.List;

public interface OrderRepository {

    Long save(Order order);

    void saveProduct(Long productId);

    boolean isProductExist(Long productId);

    List<Order> findAll();

    Order findById(Long id);

    void update(Order order);
}
