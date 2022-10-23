package com.purchases.adapters.out.persistence.product.mapper;

import com.purchases.adapters.out.persistence.product.entities.ProductEntity;
import com.purchases.adapters.out.persistence.purchase.mapper.PurchaseMapper;
import com.purchases.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final PurchaseMapper purchaseMapper;

    public Product toProduct(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .quantity(productEntity.getQuantity())
                .priceTotal(productEntity.getPriceTotal())
                .purchase(purchaseMapper.toPurchase(productEntity.getPurchase()))
                .build();
    }

    public ProductEntity toProductEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .priceTotal(product.getPriceTotal())
                .purchase(purchaseMapper.toPurchaseEntity(product.getPurchase()))
                .build();
    }
}
