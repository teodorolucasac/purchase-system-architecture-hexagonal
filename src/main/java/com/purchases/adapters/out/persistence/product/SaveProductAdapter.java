package com.purchases.adapters.out.persistence.product;

import com.purchases.adapters.out.persistence.product.entities.ProductEntity;
import com.purchases.adapters.out.persistence.product.mapper.ProductMapper;
import com.purchases.adapters.out.persistence.product.repository.ProductRepository;
import com.purchases.adapters.out.persistence.purchase.mapper.PurchaseMapper;
import com.purchases.adapters.out.persistence.purchase.repository.PurchaseRepository;
import com.purchases.application.port.out.SaveProductPort;
import com.purchases.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaveProductAdapter implements SaveProductPort {

    private final ProductMapper mapper;
    private final ProductRepository repository;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    public Product saveProduct(Product product, int purchaseId) {
        var purchaseEntity = purchaseRepository.findById(purchaseId);
        var productEntity = mapper.toProductEntity(product);

        productEntity.setPurchase(purchaseEntity.get());
        productEntity.setPriceTotal(productEntity.getPrice() * productEntity.getQuantity());

        var totalPurchase = productEntity.getPurchase().getTotalValue();

        // If > 0 porque o typeof do ID é int
        if(productEntity.getId() > 0){
            var oldProductEntity = repository.findById(productEntity.getId());
            productEntity.getPurchase().setTotalValue(totalPurchase -= oldProductEntity.get().getPriceTotal());
        }
        productEntity.getPurchase().setTotalValue(totalPurchase += productEntity.getPriceTotal());

        return mapper.toProduct(repository.save(productEntity));
    }

    @Override
    public Iterable<ProductEntity> findAllProducts() {
        return repository.findAll();
    }

    @Override
    public Iterable<ProductEntity> findProductsByName(String partName) {
        return repository.findByNameContainingIgnoreCase(partName);
    }

    @Override
    public Iterable<ProductEntity> findProductsByPage(int numberPages, int numberProducts) {
        if(numberProducts <= 0) numberProducts = 1;
        if(numberProducts >= 5) numberProducts = 5;

        Pageable page = PageRequest.of(numberPages, numberProducts);
        return repository.findAll(page);
    }

    @Override
    public Optional<ProductEntity> findProductById(int id) {
        return repository.findById(id);
    }

    @Override
    public void deleteProductById(int id) {
        repository.deleteById(id);
    }
}
