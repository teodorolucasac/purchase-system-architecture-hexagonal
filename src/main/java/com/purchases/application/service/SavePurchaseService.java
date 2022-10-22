package com.purchases.application.service;

import com.purchases.adapters.out.persistence.client.mapper.ClientMapper;
import com.purchases.adapters.out.persistence.client.repository.ClientRepository;
import com.purchases.application.port.in.SavePurchaseUseCase;
import com.purchases.application.port.out.SavePurchasePort;
import com.purchases.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SavePurchaseService implements SavePurchaseUseCase {

    private final SavePurchasePort port;
    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    @Override
    public Purchase savePurchase(Purchase purchase, int clientId) {
        var clientDB = clientRepository.findById(clientId);
        purchase.setClient(mapper.toClient(clientDB.get()));
        return port.savePurchase(purchase);
    }
}
