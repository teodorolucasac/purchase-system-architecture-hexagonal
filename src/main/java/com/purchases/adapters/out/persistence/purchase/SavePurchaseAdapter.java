package com.purchases.adapters.out.persistence.purchase;

import com.purchases.adapters.out.persistence.client.mapper.ClientMapper;
import com.purchases.adapters.out.persistence.purchase.mapper.PurchaseMapper;
import com.purchases.adapters.out.persistence.purchase.repository.PurchaseRepository;
import com.purchases.application.port.out.SavePurchasePort;
import com.purchases.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SavePurchaseAdapter implements SavePurchasePort {

    private final PurchaseMapper mapper;
//  private final ClientMapper clientMapper;
    private final PurchaseRepository repository;

    @Override
    public Purchase savePurchase(Purchase purchase) {
        var purchaseEntity = mapper.toPurchaseEntity(purchase);

        repository.save(purchaseEntity);
        return mapper.toPurchase(purchaseEntity);
    }
}