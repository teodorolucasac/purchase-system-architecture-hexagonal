package com.purchases.application.service;

import com.purchases.adapters.out.persistence.client.mapper.ClientMapper;
import com.purchases.adapters.out.persistence.client.repository.ClientRepository;
import com.purchases.adapters.out.persistence.purchase.mapper.PurchaseMapper;
import com.purchases.application.port.in.SavePurchaseUseCase;
import com.purchases.application.port.out.SavePurchasePort;
import com.purchases.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavePurchaseService implements SavePurchaseUseCase {

    private final SavePurchasePort port;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public Purchase savePurchase(Purchase purchase, int clientId) {
        var clientEntity = clientRepository.findById(clientId);
        var client = clientMapper.toClient(clientEntity.get());
        purchase.setClient(client);
        return port.savePurchase(purchase);
    }
}
