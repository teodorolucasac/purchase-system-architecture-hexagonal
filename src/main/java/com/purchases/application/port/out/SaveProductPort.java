package com.purchases.application.port.out;

import com.purchases.domain.Product;

public interface SaveProductPort {

    Product saveProduct(Product product);
}
