package com.ecommerce.order.infrastructure.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COMMERCE_ORDER")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private int orderQuantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
