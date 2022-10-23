package com.purchases.adapters.out.persistence.purchase.repository;

import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Integer> {
    Iterable<PurchaseEntity> findByNameContainingIgnoreCase(String partName);
}
