package com.purchases.adapters.out.persistence.product;

import com.purchases.adapters.out.persistence.product.mapper.ProductMapper;
import com.purchases.adapters.out.persistence.product.repository.ProductRepository;
import com.purchases.application.port.out.SaveProductPort;
import com.purchases.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProductAdapter implements SaveProductPort {

    private final ProductMapper mapper;
    private final ProductRepository repository;

    @Override
    public Product saveProduct(Product product) {
        var productEntity = mapper.toProductEntity(product);
        repository.save(productEntity);
        return mapper.toProduct(productEntity);
    }
}
