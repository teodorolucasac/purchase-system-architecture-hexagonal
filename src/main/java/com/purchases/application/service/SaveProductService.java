package com.purchases.application.service;

import com.purchases.adapters.out.persistence.product.repository.ProductRepository;
import com.purchases.adapters.out.persistence.purchase.mapper.PurchaseMapper;
import com.purchases.adapters.out.persistence.purchase.repository.PurchaseRepository;
import com.purchases.application.port.in.SaveProductUseCase;
import com.purchases.application.port.out.SaveProductPort;
import com.purchases.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProductService implements SaveProductUseCase {

    private final SaveProductPort port;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    public Product saveProduct(Product product, int purchaseId) {
        var purchaseEntity = purchaseRepository.findById(purchaseId);
        var purchase = purchaseMapper.toPurchase(purchaseEntity.get());
        product.setPurchase(purchase);
        System.out.println(product.getPurchase());
        return port.saveProduct(product);
    }
}
