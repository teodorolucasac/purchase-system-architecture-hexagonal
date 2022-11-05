package com.purchases.adapters.out.persistence.client;

import com.purchases.adapters.out.persistence.client.mapper.ClientMapper;
import com.purchases.adapters.out.persistence.client.repository.ClientRepository;
import com.purchases.application.port.out.CrudClientPort;
import com.purchases.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrudClientAdapter implements CrudClientPort {

    private final ClientMapper mapper;
    private final ClientRepository repository;

    @Override
    public Client saveClient(Client client) {
        return mapper.toClient(repository.save(mapper.toClientEntity(client)));
    }

    @Override
    public Client updateClient(Client client) {
        return mapper.toClient(repository.save(mapper.toClientEntity(client)));
    }

    @Override
    public List<Client> findAllClients() {
        return mapper.toClient(repository.findAll());
    }

    @Override
    public List<Client> findClientsByName(String partName) {
        return mapper.toClient(repository.findByNameContainingIgnoreCase(partName));
    }

    @Override
    public List<Client> findClientsByPage(int numberPages, int numberClients) {
        if(numberClients >= 5) numberClients = 5;
        if(numberClients <= 0) numberClients = 1;


        Pageable page = PageRequest.of(numberPages, numberClients);
        return mapper.toClient(repository.findAll(page));
    }

    @Override
    public Client findClientById(int id) {
        return mapper.toClient(repository.findById(id));
    }

    @Override
    public void deleteClientById(int id) {
        repository.deleteById(id);
    }
}
