package com.purchases.adapters.in.web.purchase.controller;

import com.purchases.adapters.in.web.client.dto.ClientDTO;
import com.purchases.adapters.in.web.purchase.dto.PurchaseDTO;
import com.purchases.adapters.in.web.purchase.mapper.PurchaseDtoMapper;
import com.purchases.application.port.in.SavePurchaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final SavePurchaseUseCase usecase;
    private final PurchaseDtoMapper mapper;

    @PostMapping
    PurchaseDTO newClient(@RequestBody PurchaseDTO purchaseDTO) {
        return mapper.toPurchaseDto(usecase.savePurchase(mapper.toPurchase(purchaseDTO)));
    }
}
