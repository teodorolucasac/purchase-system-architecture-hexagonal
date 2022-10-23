package com.purchases.application.service;

import com.purchases.adapters.out.persistence.product.entities.ProductEntity;
import com.purchases.application.port.in.SaveProductUseCase;
import com.purchases.application.port.out.SaveProductPort;
import com.purchases.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaveProductService implements SaveProductUseCase {

    private final SaveProductPort port;

    @Override
    public Product saveProduct(Product product, int purchaseId) {
        return port.saveProduct(product, purchaseId);
    }

    @Override
    public Iterable<ProductEntity> findAllProducts() {
        return port.findAllProducts();
    }

    @Override
    public Iterable<ProductEntity> findProductsByName(String partName) {
        return port.findProductsByName(partName);
    }

    @Override
    public Iterable<ProductEntity> findProductsByPage(int numberPages, int numberProducts) {
        return port.findProductsByPage(numberPages, numberProducts);
    }

    @Override
    public Optional<ProductEntity> findProductById(int id) {
        return port.findProductById(id);
    }

    @Override
    public void deleteProductById(int id) {
        port.deleteProductById(id);
    }
}
