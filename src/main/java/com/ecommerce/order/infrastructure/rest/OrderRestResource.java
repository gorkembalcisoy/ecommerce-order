package com.ecommerce.order.infrastructure.rest;

import lombok.Data;

@Data
public class OrderRestResource {

    private Long id;
    private Long productId;
    private int orderQuantity;
    private String orderStatus;
}
