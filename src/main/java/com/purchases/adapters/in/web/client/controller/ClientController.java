package com.purchases.adapters.in.web.client.controller;

import com.purchases.adapters.in.web.client.dto.ClientDTO;
import com.purchases.adapters.in.web.client.mapper.ClientDtoMapper;
import com.purchases.application.port.in.CrudClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/clients")
public class ClientController {

    private final CrudClientUseCase usecase;

    private final ClientDtoMapper mapper;

    @PostMapping
    ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return mapper.toDto(usecase.saveClient(mapper.toClient(clientDTO)));
    }

    @PutMapping
    ClientDTO updateClient(@RequestBody ClientDTO clientDTO) {
        return mapper.toDto(usecase.updateClient(mapper.toClient(clientDTO)));
    }

    @GetMapping
    List<ClientDTO> findAllClients() {
        return mapper.toDto(usecase.findAllClients());
    }

    @GetMapping(path = "/name/{partName}")
    public List<ClientDTO> findClientsByName(@PathVariable String partName) {
        return mapper.toDto(usecase.findClientsByName(partName));
    }

    @GetMapping(path = "/page/{numberPages}/{numberClients}")
    List<ClientDTO> findClientsByPage(@PathVariable int numberPages, @PathVariable int numberClients) {
        return mapper.toDto(usecase.findClientsByPage(numberPages, numberClients));
    }

    @GetMapping(path = "/{id}")
    ClientDTO findClientById(@PathVariable int id) {
        var t = usecase.findClientById(id);
        return mapper.toDto(usecase.findClientById(id));
    }

    @DeleteMapping(path = "/{id}")
    void deleteClient(@PathVariable int id) {
        usecase.deleteClientById(id);
    }


}
