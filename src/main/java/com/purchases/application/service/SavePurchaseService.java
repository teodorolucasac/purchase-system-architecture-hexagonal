package com.purchases.application.service;

import com.purchases.adapters.out.persistence.client.mapper.ClientMapper;
import com.purchases.adapters.out.persistence.client.repository.ClientRepository;
import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import com.purchases.adapters.out.persistence.purchase.mapper.PurchaseMapper;
import com.purchases.application.port.in.SavePurchaseUseCase;
import com.purchases.application.port.out.SavePurchasePort;
import com.purchases.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SavePurchaseService implements SavePurchaseUseCase {

    private final SavePurchasePort port;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public Purchase savePurchase(Purchase purchase, int clientId) {
//        var clientEntity = clientRepository.findById(purchase.getId());
//        var client = clientMapper.toClient(clientEntity.get());
//        purchase.setClient(client);
        return port.savePurchase(purchase, clientId);
    }

    @Override
    public Iterable<PurchaseEntity> findAllPurchases() {
        return port.findAllPurchases();
    }

    @Override
    public Iterable<PurchaseEntity> findPurchasesByName(String partName) {
        return port.findPurchasesByName(partName);
    }

    @Override
    public Iterable<PurchaseEntity> findPurchasesByPage(int numberPages, int numberPurchases) {
        return port.findPurchasesByPage(numberPages, numberPurchases);
    }

    @Override
    public Optional<PurchaseEntity> findPurchaseById(int id) {
        return port.findPurchaseById(id);
    }

    @Override
    public void deletePurchaseById(int id) {
        port.deletePurchaseById(id);
    }
}
