package com.purchases.adapters.in.web.product.mapper;

import com.purchases.adapters.in.web.client.dto.ClientDTO;
import com.purchases.adapters.in.web.product.dto.ProductDTO;
import com.purchases.domain.Client;
import com.purchases.domain.Product;
import org.springframework.stereotype.Component;

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
                .purchaseId(product.getId())
                .purchaseId(product.getPurchase().getId())
                .build();
    }
}
