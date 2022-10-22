package com.purchases.application.port.in;

import com.purchases.domain.Product;

public interface SaveProductUseCase {

    Product saveProduct(Product product, int productId);
}
