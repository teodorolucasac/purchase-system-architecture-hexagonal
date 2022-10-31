package com.purchases.adapters.in.web.product.controller;

import com.purchases.adapters.in.web.product.dto.ProductDTO;
import com.purchases.adapters.in.web.product.mapper.ProductDtoMapper;
import com.purchases.adapters.out.persistence.product.entities.ProductEntity;
import com.purchases.application.port.in.CrudProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final CrudProductUseCase usecase;
    private final ProductDtoMapper mapper;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    ProductDTO newProduct(@RequestBody ProductDTO productDTO) {
        return mapper.toProductDto(usecase.saveProduct(mapper.toProduct(productDTO), productDTO.getPurchaseId()));
    }

    @GetMapping
    Iterable<ProductEntity> findAllProducts() {
        return usecase.findAllProducts();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<ProductEntity> findProductsByName(@PathVariable String partName) {
        return usecase.findProductsByName(partName);
    }

    @GetMapping(path = "/page/{numberPages}/{numberProducts}")
    Iterable<ProductEntity> findProductsByPage(@PathVariable int numberPages, @PathVariable int numberProducts) {
        return usecase.findProductsByPage(numberPages, numberProducts);
    }

    @GetMapping(path = "/{id}")
    Optional<ProductEntity> findProductById(@PathVariable int id) {
        return usecase.findProductById(id);
    }

    @DeleteMapping(path = "/{id}")
    void deleteProductById(@PathVariable int id) {
        usecase.deleteProductById(id);
    }
}
