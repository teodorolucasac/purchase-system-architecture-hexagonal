package com.purchases.application.service;

import com.purchases.application.port.in.CrudClientUseCase;
import com.purchases.application.port.out.CrudClientPort;
import com.purchases.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrudClientService implements CrudClientUseCase {

    private final CrudClientPort port;

    @Override
    public Client saveClient(Client client) {
        return port.saveClient(client);
    }

    @Override
    public Client updateClient(Client client) {
        return port.updateClient(client);
    }

    @Override
    public List<Client> findAllClients() {
        return port.findAllClients();
    }

    @Override
    public List<Client> findClientsByName(String partName) {
        return port.findClientsByName(partName);
    }

    @Override
    public List<Client> findClientsByPage(int numberPages, int numberClients) {
        return port.findClientsByPage(numberPages, numberClients);
    }

    @Override
    public Client findClientById(int id) {
        return port.findClientById(id);
    }

    @Override
    public void deleteClientById(int id) {
        port.deleteClientById(id);
    }
}
