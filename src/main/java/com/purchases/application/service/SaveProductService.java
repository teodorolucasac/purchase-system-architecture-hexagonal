package com.purchases.application.service;

import com.purchases.application.port.in.SaveProductUseCase;
import com.purchases.application.port.out.SaveProductPort;
import com.purchases.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProductService implements SaveProductUseCase {

    private final SaveProductPort port;

    @Override
    public Product saveProduct(Product product) {
        return port.saveProduct(product);
    }
}
