package com.purchases.adapters.out.persistence.purchase.mapper;

import com.purchases.adapters.out.persistence.client.mapper.ClientMapper;
import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import com.purchases.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PurchaseMapper {

    private final ClientMapper clientMapper;

    public Purchase toPurchase(PurchaseEntity purchaseEntity) {
        return Purchase.builder()
                .id(purchaseEntity.getId())
                .name(purchaseEntity.getName())
                .date(purchaseEntity.getDate())
                .totalValue(purchaseEntity.getTotalValue())
                .client(clientMapper.toClient(purchaseEntity.getClient()))
                .build();
    }

    public PurchaseEntity toPurchaseEntity(Purchase purchase) {
        return PurchaseEntity.builder()
                .id(purchase.getId())
                .name(purchase.getName())
                .date(purchase.getDate())
                .totalValue(purchase.getTotalValue())
                .build();
    }
}
