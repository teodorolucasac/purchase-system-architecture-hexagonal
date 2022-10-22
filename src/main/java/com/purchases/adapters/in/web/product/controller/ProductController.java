package com.purchases.adapters.in.web.product.controller;

import com.purchases.adapters.in.web.product.dto.ProductDTO;
import com.purchases.adapters.in.web.product.mapper.ProductDtoMapper;
import com.purchases.application.port.in.SaveProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final SaveProductUseCase usecase;
    private final ProductDtoMapper mapper;

    @PostMapping
    ProductDTO newProduct(@RequestBody ProductDTO productDTO) {
        var product = mapper.toProduct(productDTO);
        var purchaseId = productDTO.getPurchaseId();
        usecase.saveProduct(product, purchaseId);
        return productDTO;
    }
}
