package com.purchases.application.port.in;

import com.purchases.domain.Purchase;

import java.time.LocalDate;
import java.util.List;

public interface CrudPurchaseUseCase {

    Purchase savePurchase(Purchase purchase, int clientId);

    Purchase updatePurchase(Purchase purchase, int clientId);

    List<Purchase> findAllPurchases();

    List<Purchase> findPurchasesByName(String partName);

    List<Purchase> findPurchasesByClientAndDate(Integer clientId, LocalDate beforeDate, LocalDate afterDate);

    List<Purchase> findAllPurchasesByDate(LocalDate beforeDate, LocalDate afterDate);

    List<Purchase> findPurchasesByPage(int numberPages, int numberPurchases);

    Purchase findPurchaseById(int id);

    void deletePurchaseById(int id);
}
