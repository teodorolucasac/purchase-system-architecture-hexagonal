package com.purchases.application.service;

import com.purchases.application.port.in.CrudPurchaseUseCase;
import com.purchases.application.port.out.CrudPurchasePort;
import com.purchases.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrudPurchaseService implements CrudPurchaseUseCase {

    private final CrudPurchasePort port;

    @Override
    public Purchase savePurchase(Purchase purchase, int clientId) {
        return port.savePurchase(purchase, clientId);
    }

    @Override
    public Purchase updatePurchase(Purchase purchase, int clientId) {
        return port.updatePurchase(purchase, clientId);
    }

    @Override
    public List<Purchase> findAllPurchases() {
        return port.findAllPurchases();
    }

    @Override
    public List<Purchase> findPurchasesByName(String partName) {
        return port.findPurchasesByName(partName);
    }

    @Override
    public List<Purchase> findPurchasesByClientAndDate(Integer clientId, LocalDate beforeDate, LocalDate afterDate) {
        return port.findPurchasesByClientAndDate(clientId, beforeDate, afterDate);
    }

    @Override
    public List<Purchase> findAllPurchasesByDate(LocalDate beforeDate, LocalDate afterDate) {
        return port.findAllPurchasesByDate(beforeDate, afterDate);
    }

    @Override
    public List<Purchase> findPurchasesByPage(int numberPages, int numberPurchases) {
        return port.findPurchasesByPage(numberPages, numberPurchases);
    }

    @Override
    public Purchase findPurchaseById(int id) {
        return port.findPurchaseById(id);
    }

    @Override
    public void deletePurchaseById(int id) {
        port.deletePurchaseById(id);
    }
}
