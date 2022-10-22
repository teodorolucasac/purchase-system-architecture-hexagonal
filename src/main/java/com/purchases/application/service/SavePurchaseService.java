package com.purchases.application.service;

import com.purchases.application.port.in.SavePurchaseUseCase;
import com.purchases.application.port.out.SavePurchasePort;
import com.purchases.domain.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavePurchaseService implements SavePurchaseUseCase {

    private final SavePurchasePort port;

    @Override
    public Purchase savePurchase(Purchase purchase) {
        return port.savePurchase(purchase);
    }
}
