package com.purchases.application.port.in;

import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import com.purchases.domain.Purchase;

import java.util.Optional;

public interface SavePurchaseUseCase {

    Purchase savePurchase(Purchase purchase, int clientId);

    Iterable<PurchaseEntity> findAllPurchases();

    Iterable<PurchaseEntity> findPurchasesByName(String partName);

    Iterable<PurchaseEntity> findPurchasesByPage(int numberPages, int numberPurchases);

    Optional<PurchaseEntity> findPurchaseById(int id);

    void deletePurchaseById(int id);
}
