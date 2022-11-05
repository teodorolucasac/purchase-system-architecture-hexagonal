package com.purchases.adapters.out.persistence.product.repository;

import com.purchases.adapters.out.persistence.product.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByNameContainingIgnoreCase(String partName);
}
