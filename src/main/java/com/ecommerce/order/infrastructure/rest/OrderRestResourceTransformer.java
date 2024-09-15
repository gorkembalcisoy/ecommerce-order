package com.ecommerce.order.infrastructure.rest;

import com.ecommerce.order.domain.model.Order;

public class OrderRestResourceTransformer {

    public OrderRestResource toRestResource(Order order) {
        OrderRestResource orderRestResource = new OrderRestResource();
        orderRestResource.setId(order.getId());
        orderRestResource.setOrderStatus(order.getOrderStatus().label);
        orderRestResource.setOrderQuantity(order.getOrderQuantity());
        orderRestResource.setProductId(order.getProductId());
        return orderRestResource;
    }
}
