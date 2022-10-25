package com.purchases.adapters.in.web.purchase.controller;

import com.purchases.adapters.in.web.purchase.dto.PurchaseDTO;
import com.purchases.adapters.in.web.purchase.mapper.PurchaseDtoMapper;
import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import com.purchases.application.port.in.SavePurchaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping(path = "/teste/{clientId}/{beforeDate}/{afterDate}")
    public Iterable<PurchaseEntity> findPurchasesByDate(
            @PathVariable Integer clientId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate beforeDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate afterDate) {
        return usecase.findPurchasesByDate(clientId, beforeDate, afterDate);
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
