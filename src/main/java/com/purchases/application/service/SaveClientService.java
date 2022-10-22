package com.purchases.application.service;

import com.purchases.application.port.in.SaveClientUseCase;
import com.purchases.application.port.out.SaveClientPort;
import com.purchases.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveClientService implements SaveClientUseCase {

    private final SaveClientPort port;

    @Override
    public Client saveClient(Client client) {
        return port.saveClient(client);
    }
}
