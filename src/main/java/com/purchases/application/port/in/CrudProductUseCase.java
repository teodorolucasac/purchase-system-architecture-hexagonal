package com.purchases.application.port.in;

import com.purchases.adapters.out.persistence.product.entities.ProductEntity;
import com.purchases.domain.Product;

import java.util.Optional;

public interface CrudProductUseCase {

    Product saveProduct(Product product, int purchaseId);

    Iterable<ProductEntity> findAllProducts();

    Iterable<ProductEntity> findProductsByName(String partName);

    Iterable<ProductEntity> findProductsByPage(int numberPages, int numberProducts);

    Optional<ProductEntity> findProductById(int id);

    void deleteProductById(int id);
}