package com.purchases.adapters.in.web.purchase.mapper;

import com.purchases.adapters.in.web.purchase.dto.PurchaseDTO;
import com.purchases.domain.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PurchaseDTO> toPurchaseDto(List<Purchase> purchases) {
        return purchases.stream()
                .map(item -> this.toPurchaseDto(item))
                .collect(Collectors.toList());
    }

    public List<PurchaseDTO> toPurchaseDto(Page<Purchase> purchases) {
        return purchases.stream()
                .map(item -> this.toPurchaseDto(item))
                .collect(Collectors.toList());
    }
}
