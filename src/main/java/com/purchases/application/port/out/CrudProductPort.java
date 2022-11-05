package com.purchases.application.port.out;

import com.purchases.domain.Product;

import java.util.List;
import java.util.Optional;

public interface CrudProductPort {

    Product saveProduct(Product product, int purchaseId);

    Product updateProduct(Product product, int purchaseId);

    List<Product> findAllProducts();

    List<Product> findProductsByName(String partName);

    List<Product> findProductsByPage(int numberPages, int numberProducts);

    Product findProductById(int id);

    void deleteProductById(int id);
}
