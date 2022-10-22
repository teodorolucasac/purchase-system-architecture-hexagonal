package com.purchases.adapters.out.persistence.product.mapper;

import com.purchases.adapters.out.persistence.product.entities.ProductEntity;
import com.purchases.domain.Client;
import com.purchases.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(ProductEntity productEntity) {
        return Product.builder()
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .quantity(productEntity.getQuantity())
                .priceTotal(productEntity.getPriceTotal())
                .build();
    }

    public ProductEntity toProductEntity(Product product) {
        return ProductEntity.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .priceTotal(product.getPriceTotal())
                .build();
    }
}
