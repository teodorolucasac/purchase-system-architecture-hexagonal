package com.purchases.application.port.out;

import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import com.purchases.domain.Client;

import java.util.Optional;

public interface SaveClientPort {

    Client saveClient(Client client);

    Iterable<ClientEntity> findAllClients();

    Iterable<ClientEntity> findClientsByName(String partName);

    Iterable<ClientEntity> findClientsByPage(int numberPages, int numberClients);

    Optional<ClientEntity> findClientById(int id);

    void deleteClientById(int id);
}
