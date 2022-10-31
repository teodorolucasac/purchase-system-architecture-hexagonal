package com.purchases.application.service;

import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import com.purchases.application.port.in.CrudClientUseCase;
import com.purchases.application.port.out.CrudClientPort;
import com.purchases.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrudClientService implements CrudClientUseCase {

    private final CrudClientPort port;

    @Override
    public Client saveClient(Client client) {
        return port.saveClient(client);
    }

    @Override
    public Iterable<ClientEntity> findAllClients() {
        return port.findAllClients();
    }

    @Override
    public Iterable<ClientEntity> findClientsByName(String partName) {
        return port.findClientsByName(partName);
    }

    @Override
    public Iterable<ClientEntity> findClientsByPage(int numberPages, int numberClients) {
        return port.findClientsByPage(numberPages, numberClients);
    }

    @Override
    public Optional<ClientEntity> findClientById(int id) {
        return port.findClientById(id);
    }

    @Override
    public void deleteClientById(int id) {
        port.deleteClientById(id);
    }
}
