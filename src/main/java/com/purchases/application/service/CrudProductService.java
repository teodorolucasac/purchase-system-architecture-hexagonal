package com.purchases.application.service;

import com.purchases.application.port.in.CrudProductUseCase;
import com.purchases.application.port.out.CrudProductPort;
import com.purchases.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrudProductService implements CrudProductUseCase {

    private final CrudProductPort port;

    @Override
    public Product saveProduct(Product product, int purchaseId) {
        return port.saveProduct(product, purchaseId);
    }

    @Override
    public Product updateProduct(Product product, int purchaseId) {
        return port.updateProduct(product, purchaseId);
    }

    @Override
    public List<Product> findAllProducts() {
        return port.findAllProducts();
    }

    @Override
    public List<Product> findProductsByName(String partName) {
        return port.findProductsByName(partName);
    }

    @Override
    public List<Product> findProductsByPage(int numberPages, int numberProducts) {
        return port.findProductsByPage(numberPages, numberProducts);
    }

    @Override
    public Product findProductById(int id) {
        return port.findProductById(id);
    }

    @Override
    public void deleteProductById(int id) {
        port.deleteProductById(id);
    }
}
