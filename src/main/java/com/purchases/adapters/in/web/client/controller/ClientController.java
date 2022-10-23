package com.purchases.adapters.in.web.client.controller;

import com.purchases.adapters.in.web.client.dto.ClientDTO;
import com.purchases.adapters.in.web.client.mapper.ClientDtoMapper;
import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import com.purchases.application.port.in.SaveClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final SaveClientUseCase usecase;
    private final ClientDtoMapper mapper;

//    @PostMapping
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return mapper.toClientDto(usecase.saveClient(mapper.toClient(clientDTO)));
    }

    @GetMapping
    Iterable<ClientEntity> findAllClients() {
        return usecase.findAllClients();
    }

    @GetMapping(path = "/name/{partName}")
    public Iterable<ClientEntity> findClientsByName(@PathVariable String partName) {
        return usecase.findClientsByName(partName);
    }

    @GetMapping(path = "/page/{numberPages}/{numberClients}")
    Iterable<ClientEntity> findClientsByPage(@PathVariable int numberPages, @PathVariable int numberClients) {
        return usecase.findClientsByPage(numberPages, numberClients);
    }

    @GetMapping(path = "/{id}")
    Optional<ClientEntity> findClientById(@PathVariable int id) {
        return usecase.findClientById(id);
    }

    @DeleteMapping(path = "/{id}")
    void deleteClient(@PathVariable int id) {
        usecase.deleteClientById(id);
    }
}
