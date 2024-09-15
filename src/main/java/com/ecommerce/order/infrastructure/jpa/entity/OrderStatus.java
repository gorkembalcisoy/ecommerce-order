package com.ecommerce.order.infrastructure.jpa.entity;

public enum OrderStatus {

    WAITING("WAITING"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    public final String label;

    OrderStatus(String label) {
        this.label = label;
    }
}
