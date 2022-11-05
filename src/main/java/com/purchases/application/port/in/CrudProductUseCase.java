package com.purchases.application.port.in;

import com.purchases.domain.Product;

import java.util.List;
import java.util.Optional;

public interface CrudProductUseCase {

    Product saveProduct(Product product, int purchaseId);

    Product updateProduct(Product product, int purchaseId);

    List<Product> findAllProducts();

    List<Product> findProductsByName(String partName);

    List<Product> findProductsByPage(int numberPages, int numberProducts);

    Product findProductById(int id);

    void deleteProductById(int id);
}
