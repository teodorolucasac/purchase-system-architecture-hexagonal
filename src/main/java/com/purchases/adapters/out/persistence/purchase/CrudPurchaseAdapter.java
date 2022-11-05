package com.purchases.adapters.out.persistence.purchase;

import com.purchases.adapters.out.persistence.client.repository.ClientRepository;
import com.purchases.adapters.out.persistence.purchase.mapper.PurchaseMapper;
import com.purchases.adapters.out.persistence.purchase.repository.PurchaseRepository;
import com.purchases.application.port.out.CrudPurchasePort;
import com.purchases.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrudPurchaseAdapter implements CrudPurchasePort {

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final PurchaseMapper mapper;
    private final PurchaseRepository repository;
    private final ClientRepository clientRepository;

    @Override
    public Purchase savePurchase(Purchase purchase, int clientId) {
        var purchaseEntity = mapper.toPurchaseEntity(purchase);
        var clientEntity = clientRepository.findById(clientId);
        purchaseEntity.setClient(clientEntity.get());

        if (purchaseEntity.getTotalValue() == null) {
            purchaseEntity.setTotalValue(BigDecimal.valueOf(0.0));
        }

        if (purchaseEntity.getDate() == null) {
            purchaseEntity.setDate(LocalDate.now());
        }

        return mapper.toPurchase(repository.save(purchaseEntity));
    }

    @Override
    public Purchase updatePurchase(Purchase purchase, int clientId) {
        var purchaseEntity = mapper.toPurchaseEntity(purchase);
        var oldPurchaseEntity = repository.findById(purchaseEntity.getId());
        var clientEntity = clientRepository.findById(clientId);
        var oldClientEntity = oldPurchaseEntity.get().getClient();
        purchaseEntity.setTotalValue(oldPurchaseEntity.get().getTotalValue());

        if (clientEntity.isEmpty() || clientEntity.get().getId() == oldClientEntity.getId()) {
            purchaseEntity.setClient(oldPurchaseEntity.get().getClient());
        } else {
            purchaseEntity.setClient(clientEntity.get());
        }

        if (purchaseEntity.getDate() == null) {
            purchaseEntity.setDate(oldPurchaseEntity.get().getDate());
        }

        if (purchaseEntity.getTotalValue() == null) {
            purchaseEntity.setTotalValue(BigDecimal.valueOf(0.0));
        }

        return mapper.toPurchase(repository.save(purchaseEntity));
    }

    @Override
    public List<Purchase> findAllPurchases() {
        return mapper.toPurchase(repository.findAll());
    }

    @Override
    public List<Purchase> findPurchasesByName(String partName) {
        return mapper.toPurchase(repository.findByNameContainingIgnoreCase(partName));
    }

    @Override
    public List<Purchase> findPurchasesByClientAndDate(Integer clientId, LocalDate beforeDate, LocalDate afterDate) {
        return mapper.toPurchase(repository.findPurchasesByClientAndDate(clientId, beforeDate, afterDate));
    }

    @Override
    public List<Purchase> findAllPurchasesByDate(LocalDate beforeDate, LocalDate afterDate) {
        return mapper.toPurchase(repository.findAllPurchasesByDate(beforeDate, afterDate));
    }

    @Override
    public List<Purchase> findPurchasesByPage(int numberPages, int numberPurchases) {
        if (numberPurchases >= 5) numberPurchases = 5;
        if (numberPurchases <= 0) numberPurchases = 1;

        Pageable page = PageRequest.of(numberPages, numberPurchases);
        return mapper.toPurchase(repository.findAll(page));
    }

    @Override
    public Purchase findPurchaseById(int id) {
        return mapper.toPurchase(repository.findById(id));
    }

    @Override
    public void deletePurchaseById(int id) {
        repository.deleteById(id);
    }
}
