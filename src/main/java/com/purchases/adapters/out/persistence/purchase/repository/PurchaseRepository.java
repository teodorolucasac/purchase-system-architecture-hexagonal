package com.purchases.adapters.out.persistence.purchase.repository;

import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;


public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Integer> {
    Iterable<PurchaseEntity> findByNameContainingIgnoreCase(String partName);

//    @Query(nativeQuery = true, value = "SELECT * FROM tb_purchase WHERE client_id = :clientId AND date BETWEEN ':beforeDate' AND ':afterDate';")
    @Query("SELECT pe FROM PurchaseEntity pe WHERE pe.client.id = :clientId AND pe.date BETWEEN :beforeDate AND :afterDate")
    Iterable<PurchaseEntity> searchPurchasesByDate(@Param("clientId") Integer clientId, @Param("beforeDate") LocalDate beforeDate, @Param("afterDate") LocalDate afterDate);
}
