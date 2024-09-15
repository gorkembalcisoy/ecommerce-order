package com.ecommerce.order.domain.model;

import com.ecommerce.order.domain.exception.DomainException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Builder
public class Order {

    @Setter
    private Long id;
    private Long productId;
    private int orderQuantity;
    @Setter
    private OrderStatus orderStatus;

    public void isValid() throws DomainException {

        if (productId == null) {
            throw new DomainException("A product id value is required.");
        }
        if (this.orderQuantity < 0) {
            throw new DomainException("Order quantity must be greate than zero.");
        }
    }

}
