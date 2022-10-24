package com.purchases.adapters.in.web.purchase.controller;

import com.purchases.adapters.in.web.purchase.dto.PurchaseDTO;
import com.purchases.adapters.in.web.purchase.mapper.PurchaseDtoMapper;
import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import com.purchases.application.port.in.SavePurchaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final SavePurchaseUseCase usecase;
    private final PurchaseDtoMapper mapper;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    PurchaseDTO saveClient(@RequestBody PurchaseDTO purchaseDTO) {
        return mapper.toPurchaseDto(usecase.savePurchase(mapper.toPurchase(purchaseDTO), purchaseDTO.getClientId()));
    }

    @GetMapping
    Iterable<PurchaseEntity> findAllPurchases() {
        return usecase.findAllPurchases();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<PurchaseEntity> findPurchasesByName(@PathVariable String partName) {
        return usecase.findPurchasesByName(partName);
    }

    @GetMapping(path = "/page/{numberPages}/{numberPurchases}")
    Iterable<PurchaseEntity> findPurchasesByPage(@PathVariable int numberPages, @PathVariable int numberPurchases) {
        return usecase.findPurchasesByPage(numberPages, numberPurchases);
    }

    @GetMapping(path = "/{id}")
    Optional<PurchaseEntity> findPurchaseById(@PathVariable int id) {
        return usecase.findPurchaseById(id);
    }

    @DeleteMapping(path = "/{id}")
    void deletePurchaseById(@PathVariable int id) {
        usecase.deletePurchaseById(id);
    }
}
