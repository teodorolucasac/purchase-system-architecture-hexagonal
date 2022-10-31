package com.purchases.adapters.out.persistence.purchase;

import com.purchases.adapters.out.persistence.client.mapper.ClientMapper;
import com.purchases.adapters.out.persistence.client.repository.ClientRepository;
import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import com.purchases.adapters.out.persistence.purchase.mapper.PurchaseMapper;
import com.purchases.adapters.out.persistence.purchase.repository.PurchaseRepository;
import com.purchases.application.port.out.CrudPurchasePort;
import com.purchases.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrudPurchaseAdapter implements CrudPurchasePort {

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final PurchaseMapper mapper;
    private final PurchaseRepository repository;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public Purchase savePurchase(Purchase purchase, int clientId) {
        var clientEntity = clientRepository.findById(clientId);
        var purchaseEntity = mapper.toPurchaseEntity(purchase);
        purchaseEntity.setClient(clientEntity.get());

        if(purchaseEntity.getDate() == null) {
            purchaseEntity.setDate(LocalDate.now());
        }
        if(purchaseEntity.getTotalValue() == null) {
            purchaseEntity.setTotalValue(0.0);
        }

        return mapper.toPurchase(repository.save(purchaseEntity));
    }

    @Override
    public Iterable<PurchaseEntity> findAllPurchases() {
        return repository.findAll();
    }

    @Override
    public Iterable<PurchaseEntity> findPurchasesByName(String partName) {
        return repository.findByNameContainingIgnoreCase(partName);
    }

    @Override
    public Iterable<PurchaseEntity> findPurchasesByDate(Integer clientId, LocalDate beforeDate, LocalDate afterDate) {
        return repository.searchPurchasesByDate(clientId, beforeDate, afterDate);
    }

    @Override
    public Iterable<PurchaseEntity> findPurchasesByPage(int numberPages, int numberPurchases) {
        if(numberPurchases >= 5) numberPurchases = 5;
        if(numberPurchases <= 0) numberPurchases = 1;

        Pageable page = PageRequest.of(numberPages, numberPurchases);
        return repository.findAll(page);
    }

    @Override
    public Optional<PurchaseEntity> findPurchaseById(int id) {
        return repository.findById(id);
    }

    @Override
    public void deletePurchaseById(int id) {
        repository.deleteById(id);
    }
}
