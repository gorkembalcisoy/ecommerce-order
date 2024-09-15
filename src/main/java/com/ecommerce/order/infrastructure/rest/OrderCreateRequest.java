package com.ecommerce.order.infrastructure.rest;

import lombok.Data;

@Data
public class OrderCreateRequest {

    private Long productId;
    private int orderQuantity;
}
