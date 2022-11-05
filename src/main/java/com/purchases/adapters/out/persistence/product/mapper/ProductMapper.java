package com.purchases.adapters.out.persistence.product.mapper;

import com.purchases.adapters.out.persistence.product.entities.ProductEntity;
import com.purchases.adapters.out.persistence.purchase.mapper.PurchaseMapper;
import com.purchases.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final PurchaseMapper purchaseMapper;

    public ProductEntity toProductEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .priceTotal(product.getPriceTotal())
                .build();
    }

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

    public Product toProduct(Optional<ProductEntity> productEntity) {
        return Product.builder()
                .id(productEntity.get().getId())
                .name(productEntity.get().getName())
                .price(productEntity.get().getPrice())
                .quantity(productEntity.get().getQuantity())
                .priceTotal(productEntity.get().getPriceTotal())
                .purchase(purchaseMapper.toPurchase(productEntity.get().getPurchase()))
                .build();
    }

    public List<Product> toProduct(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(item -> this.toProduct(item))
                .collect(Collectors.toList());
    }

    public List<Product> toProduct(Page<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(item -> this.toProduct(item))
                .collect(Collectors.toList());
    }
}
