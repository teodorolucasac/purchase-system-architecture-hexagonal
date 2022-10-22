package com.purchases.application.port.out;

import com.purchases.domain.Purchase;

public interface SavePurchasePort {

    Purchase savePurchase(Purchase purchase);
}
