package com.purchases.application.port.in;

import com.purchases.domain.Client;
import com.purchases.domain.Purchase;

public interface SavePurchaseUseCase {

    Purchase savePurchase(Purchase purchase);
}
