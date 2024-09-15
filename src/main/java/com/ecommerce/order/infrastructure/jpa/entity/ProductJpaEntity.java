package com.ecommerce.order.infrastructure.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductJpaEntity {

    @Id
    private Long id;
}
