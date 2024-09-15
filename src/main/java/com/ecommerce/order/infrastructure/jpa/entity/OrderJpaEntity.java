package com.ecommerce.order.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COMMERCE_ORDER", indexes = @Index(name="order_product_id_index", columnList = "productId"))
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private Long productId;

    @Setter
    @Column(nullable = false)
    private int orderQuantity;

    @Setter
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
