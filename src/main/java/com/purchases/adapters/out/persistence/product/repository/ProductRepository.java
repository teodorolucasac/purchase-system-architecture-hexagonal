package com.purchases.adapters.out.persistence.product.repository;

import com.purchases.adapters.out.persistence.product.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByNameContainingIgnoreCase(String partName);
}
