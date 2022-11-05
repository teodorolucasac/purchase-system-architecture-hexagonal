package com.purchases.adapters.in.web.product.mapper;

import com.purchases.adapters.in.web.product.dto.ProductDTO;
import com.purchases.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDtoMapper {

    public Product toProduct(ProductDTO productDTO) {
        return Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .priceTotal(productDTO.getPriceTotal())
                .build();
    }

    public ProductDTO toProductDto(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .priceTotal(product.getPriceTotal())
                .purchaseId(product.getPurchase().getId())
                .build();
    }

    public List<ProductDTO> toProductDto(List<Product> products){
        return products.stream()
                .map(item -> this.toProductDto(item))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> toProductDto(Page<Product> products){
        return products.stream()
                .map(item -> this.toProductDto(item))
                .collect(Collectors.toList());
    }
}
