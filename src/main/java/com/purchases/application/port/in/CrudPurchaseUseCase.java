package com.purchases.application.port.in;

import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import com.purchases.domain.Purchase;

import java.time.LocalDate;
import java.util.Optional;

public interface CrudPurchaseUseCase {

    Purchase savePurchase(Purchase purchase, int clientId);

    Iterable<PurchaseEntity> findAllPurchases();

    Iterable<PurchaseEntity> findPurchasesByName(String partName);

    Iterable<PurchaseEntity> findPurchasesByDate(Integer clientId, LocalDate beforeDate, LocalDate afterDate);

    Iterable<PurchaseEntity> findPurchasesByPage(int numberPages, int numberPurchases);

    Optional<PurchaseEntity> findPurchaseById(int id);

    void deletePurchaseById(int id);
}
