package com.purchases.adapters.out.persistence.product;

import com.purchases.adapters.out.persistence.product.mapper.ProductMapper;
import com.purchases.adapters.out.persistence.product.repository.ProductRepository;
import com.purchases.adapters.out.persistence.purchase.repository.PurchaseRepository;
import com.purchases.application.port.out.CrudProductPort;
import com.purchases.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrudProductAdapter implements CrudProductPort {

    private final ProductMapper mapper;
    private final ProductRepository repository;
    private final PurchaseRepository purchaseRepository;

    @Override
    public Product saveProduct(Product product, int purchaseId) {
        var productEntity = mapper.toProductEntity(product);
        productEntity.setPriceTotal(productEntity.getPrice().multiply(productEntity.getQuantity()));

        var purchaseEntity = purchaseRepository.findById(purchaseId);
        productEntity.setPurchase(purchaseEntity.get());

        purchaseEntity.get().setTotalValue(purchaseEntity.get().getTotalValue().add(productEntity.getPriceTotal()));

        return mapper.toProduct(repository.save(productEntity));
    }

    @Override
    public Product updateProduct(Product product, int purchaseId) {
        var productEntity = mapper.toProductEntity(product);
        var purchaseEntity = purchaseRepository.findById(purchaseId);
        var oldProductEntity = repository.findById(productEntity.getId());
        var oldPurchaseEntity = oldProductEntity.get().getPurchase();
        productEntity.setPriceTotal(productEntity.getPrice().multiply(productEntity.getQuantity()));

        oldPurchaseEntity.setTotalValue(oldPurchaseEntity.getTotalValue().subtract(oldProductEntity.get().getPriceTotal()));
        if (purchaseEntity.isEmpty()) {
            oldPurchaseEntity.setTotalValue(oldPurchaseEntity.getTotalValue().add(productEntity.getPriceTotal()));
            productEntity.setPurchase(oldPurchaseEntity);
        } else if (purchaseEntity.isPresent() && purchaseEntity.get().getId() == oldPurchaseEntity.getId()) {
            oldPurchaseEntity.setTotalValue(oldPurchaseEntity.getTotalValue().add(productEntity.getPriceTotal()));
            productEntity.setPurchase(purchaseEntity.get());
        } else {
            purchaseEntity.get().setTotalValue(purchaseEntity.get().getTotalValue().add(productEntity.getPriceTotal()));
            productEntity.setPurchase(purchaseEntity.get());
        }

        return mapper.toProduct(repository.save(productEntity));
    }


    @Override
    public List<Product> findAllProducts() {
        return mapper.toProduct(repository.findAll());
    }

    @Override
    public List<Product> findProductsByName(String partName) {
        return mapper.toProduct(repository.findByNameContainingIgnoreCase(partName));
    }

    @Override
    public List<Product> findProductsByPage(int numberPages, int numberProducts) {
        if(numberProducts <= 0) numberProducts = 1;
        if(numberProducts >= 5) numberProducts = 5;

        Pageable page = PageRequest.of(numberPages, numberProducts);
        return mapper.toProduct(repository.findAll(page));
    }

    @Override
    public Product findProductById(int id) {
        return mapper.toProduct(repository.findById(id));
    }

    @Override
    public void deleteProductById(int id) {
        var productEntity = repository.findById(id);
        productEntity.get().getPurchase().setTotalValue(
                productEntity.get().getPurchase().getTotalValue().subtract(productEntity.get().getPriceTotal()));
        repository.deleteById(id);
    }
}
