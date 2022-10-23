package com.purchases.adapters.in.web.purchase.mapper;

import com.purchases.adapters.in.web.client.dto.ClientDTO;
import com.purchases.adapters.in.web.purchase.dto.PurchaseDTO;
import com.purchases.domain.Client;
import com.purchases.domain.Purchase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class PurchaseDtoMapper {

    public Purchase toPurchase(PurchaseDTO purchaseDTO) {
        return Purchase.builder()
                .id(purchaseDTO.getId())
                .name(purchaseDTO.getName())
                .date(purchaseDTO.getDate())
                .totalValue(purchaseDTO.getTotalValue())
                .build();
    }

    public PurchaseDTO toPurchaseDto(Purchase purchase) {
        return PurchaseDTO.builder()
                .id(purchase.getId())
                .name(purchase.getName())
                .date(purchase.getDate())
                .totalValue(purchase.getTotalValue())
                .clientId(purchase.getClient().getId())
                .build();
    }
}
