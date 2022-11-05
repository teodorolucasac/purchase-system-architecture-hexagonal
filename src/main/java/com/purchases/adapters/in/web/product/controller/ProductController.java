package com.purchases.adapters.in.web.product.controller;

import com.purchases.adapters.in.web.product.dto.ProductDTO;
import com.purchases.adapters.in.web.product.mapper.ProductDtoMapper;
import com.purchases.application.port.in.CrudProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final CrudProductUseCase usecase;
    private final ProductDtoMapper mapper;

    @PostMapping
    ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return mapper.toProductDto(usecase.saveProduct(mapper.toProduct(productDTO), productDTO.getPurchaseId()));
    }

    @PutMapping
    ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return mapper.toProductDto(usecase.updateProduct(mapper.toProduct(productDTO), productDTO.getPurchaseId()));
    }

    @GetMapping
    List<ProductDTO> findAllProducts() {
        return mapper.toProductDto(usecase.findAllProducts());
    }

    @GetMapping(path = "/name/{partName}")
    List<ProductDTO> findProductsByName(@PathVariable String partName) {
        return mapper.toProductDto(usecase.findProductsByName(partName));
    }

    @GetMapping(path = "/page/{numberPages}/{numberProducts}")
    List<ProductDTO> findProductsByPage(@PathVariable int numberPages, @PathVariable int numberProducts) {
        return mapper.toProductDto(usecase.findProductsByPage(numberPages, numberProducts));
    }

    @GetMapping(path = "/{id}")
    ProductDTO findProductById(@PathVariable int id) {
        return mapper.toProductDto(usecase.findProductById(id));
    }

    @DeleteMapping(path = "/{id}")
    void deleteProductById(@PathVariable int id) {
        usecase.deleteProductById(id);
    }
}
