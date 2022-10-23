package com.purchases.adapters.out.persistence.client;

import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import com.purchases.adapters.out.persistence.client.mapper.ClientMapper;
import com.purchases.adapters.out.persistence.client.repository.ClientRepository;
import com.purchases.application.port.out.SaveClientPort;
import com.purchases.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Iterable<ClientEntity> findAllClients() {
        return repository.findAll();
    }

    @Override
    public Iterable<ClientEntity> findClientsByName(String partName) {
        return repository.findByNameContainingIgnoreCase(partName);
    }

    @Override
    public Iterable<ClientEntity> findClientsByPage(int numberPages, int numberClients) {
        if(numberClients >= 3) numberClients = 3;
        if(numberClients <= 0) numberClients = 1;

        Pageable page = PageRequest.of(numberPages, numberClients);
        return repository.findAll(page);
    }

    @Override
    public Optional<ClientEntity> findClientById(int id) {
        return repository.findById(id);
    }

    @Override
    public void deleteClientById(int id) {
        repository.deleteById(id);
    }
}
