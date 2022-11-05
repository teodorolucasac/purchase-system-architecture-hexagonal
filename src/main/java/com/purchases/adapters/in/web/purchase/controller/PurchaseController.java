package com.purchases.adapters.in.web.purchase.controller;

import com.purchases.adapters.in.web.purchase.dto.PurchaseDTO;
import com.purchases.adapters.in.web.purchase.mapper.PurchaseDtoMapper;
import com.purchases.application.port.in.CrudPurchaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final CrudPurchaseUseCase usecase;
    private final PurchaseDtoMapper mapper;

    @PostMapping
    PurchaseDTO saveClient(@RequestBody PurchaseDTO purchaseDTO) {
        return mapper.toPurchaseDto(usecase.savePurchase(mapper.toPurchase(purchaseDTO), purchaseDTO.getClientId()));
    }

    @PutMapping
    PurchaseDTO updateClient(@RequestBody PurchaseDTO purchaseDTO) {
        return mapper.toPurchaseDto(usecase.updatePurchase(mapper.toPurchase(purchaseDTO), purchaseDTO.getClientId()));
    }

    @GetMapping
    List<PurchaseDTO> findAllPurchases() {
        return mapper.toPurchaseDto(usecase.findAllPurchases());
    }

    @GetMapping(path = "/name/{partName}")
    public List<PurchaseDTO> findPurchasesByName(@PathVariable String partName) {
        return mapper.toPurchaseDto(usecase.findPurchasesByName(partName));
    }

    @GetMapping(path = "/date/{clientId}/{beforeDate}/{afterDate}")
    public List<PurchaseDTO> findPurchasesByClientAndDate(
            @PathVariable Integer clientId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate beforeDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate afterDate) {
        return mapper.toPurchaseDto(usecase.findPurchasesByClientAndDate(clientId, beforeDate, afterDate));
    }

    @GetMapping(path = "/date/{beforeDate}/{afterDate}")
    public List<PurchaseDTO> findAllPurchasesByDate(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate beforeDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate afterDate) {
        return mapper.toPurchaseDto(usecase.findAllPurchasesByDate(beforeDate, afterDate));
    }

    @GetMapping(path = "/page/{numberPages}/{numberPurchases}")
    List<PurchaseDTO> findPurchasesByPage(@PathVariable int numberPages, @PathVariable int numberPurchases) {
        return mapper.toPurchaseDto(usecase.findPurchasesByPage(numberPages, numberPurchases));
    }

    @GetMapping(path = "/{id}")
    PurchaseDTO findPurchaseById(@PathVariable int id) {
        return mapper.toPurchaseDto(usecase.findPurchaseById(id));
    }

    @DeleteMapping(path = "/{id}")
    void deletePurchaseById(@PathVariable int id) {
        usecase.deletePurchaseById(id);
    }
}
