package com.purchases.application.port.in;

import com.purchases.domain.Client;

import java.util.List;

public interface CrudClientUseCase {

    Client saveClient(Client client);

    Client updateClient(Client client);

    List<Client> findAllClients();

    List<Client> findClientsByName(String partName);

    List<Client> findClientsByPage(int numberPages, int numberClients);

    Client findClientById(int id);

    void deleteClientById(int id);
}
