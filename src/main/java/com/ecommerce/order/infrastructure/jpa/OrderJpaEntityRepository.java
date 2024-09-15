package com.ecommerce.order.infrastructure.jpa;

import com.ecommerce.order.infrastructure.jpa.entity.OrderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface OrderJpaEntityRepository extends JpaRepository<OrderJpaEntity, Long> {
}
