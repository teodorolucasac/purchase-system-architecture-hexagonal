package com.purchases.adapters.out.persistence.purchase.mapper;

import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import com.purchases.domain.Client;
import com.purchases.domain.Purchase;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {

    public Purchase toPurchase(PurchaseEntity purchaseEntity) {
        return Purchase.builder()
                .name(purchaseEntity.getName())
                .date(purchaseEntity.getDate())
                .totalValue(purchaseEntity.getTotalValue())
                .clientId(purchaseEntity.getClient().getId())
                .build();
    }

    public PurchaseEntity toPurchaseEntity(Purchase purchase) {
        return PurchaseEntity.builder()
                .name(purchase.getName())
                .date(purchase.getDate())
                .totalValue(purchase.getTotalValue())
                .idDomain(purchase.getClient().getId())
                .build();
    }
}
