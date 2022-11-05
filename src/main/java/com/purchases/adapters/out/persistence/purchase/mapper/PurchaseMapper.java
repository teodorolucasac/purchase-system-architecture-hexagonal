package com.purchases.adapters.out.persistence.purchase.mapper;

import com.purchases.adapters.out.persistence.client.mapper.ClientMapper;
import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import com.purchases.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PurchaseMapper {

    private final ClientMapper clientMapper;

    public PurchaseEntity toPurchaseEntity(Purchase purchase) {
        return PurchaseEntity.builder()
                .id(purchase.getId())
                .name(purchase.getName())
                .date(purchase.getDate())
                .totalValue(purchase.getTotalValue())
                .build();
    }

    public Purchase toPurchase(PurchaseEntity purchaseEntity) {
        return Purchase.builder()
                .id(purchaseEntity.getId())
                .name(purchaseEntity.getName())
                .date(purchaseEntity.getDate())
                .totalValue(purchaseEntity.getTotalValue())
                .client(clientMapper.toClient(purchaseEntity.getClient()))
                .build();
    }

    public Purchase toPurchase(Optional<PurchaseEntity> purchaseEntity) {
        return Purchase.builder()
                .id(purchaseEntity.get().getId())
                .name(purchaseEntity.get().getName())
                .date(purchaseEntity.get().getDate())
                .totalValue(purchaseEntity.get().getTotalValue())
                .client(clientMapper.toClient(purchaseEntity.get().getClient()))
                .build();
    }

    public List<Purchase> toPurchase(List<PurchaseEntity> purchaseEntities) {
        return purchaseEntities.stream()
                .map(item -> this.toPurchase(item))
                .collect(Collectors.toList());
    }

    public List<Purchase> toPurchase(Page<PurchaseEntity> purchaseEntities) {
        return purchaseEntities.stream()
                .map(item -> this.toPurchase(item))
                .collect(Collectors.toList());
    }
}
