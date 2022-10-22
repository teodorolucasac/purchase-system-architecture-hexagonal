package com.purchases.adapters.out.persistence.client;

import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import com.purchases.adapters.out.persistence.client.mapper.ClientMapper;
import com.purchases.adapters.out.persistence.client.repository.ClientRepository;
import com.purchases.application.port.out.SaveClientPort;
import com.purchases.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveClientAdapter implements SaveClientPort {

    private final ClientMapper mapper;
    private final ClientRepository repository;

    @Override
    public Client saveClient(Client client) {
        var clientEntity = mapper.toClientEntity(client);
        repository.save(clientEntity);
        return mapper.toClient(clientEntity);
    }
}
