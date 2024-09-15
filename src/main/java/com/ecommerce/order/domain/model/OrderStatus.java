package com.ecommerce.order.domain.model;

public enum OrderStatus {

    WAITING("WAITING"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    public final String label;

    OrderStatus(String label) {
        this.label = label;
    }
}
