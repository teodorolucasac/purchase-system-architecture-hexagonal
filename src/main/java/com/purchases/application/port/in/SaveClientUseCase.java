package com.purchases.application.port.in;

import com.purchases.domain.Client;

public interface SaveClientUseCase {

    Client saveClient(Client client);
}
