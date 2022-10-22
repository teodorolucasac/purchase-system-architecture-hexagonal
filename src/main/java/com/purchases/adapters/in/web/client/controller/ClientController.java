package com.purchases.adapters.in.web.client.controller;

import com.purchases.adapters.in.web.client.dto.ClientDTO;
import com.purchases.adapters.in.web.client.mapper.ClientDtoMapper;
import com.purchases.application.port.in.SaveClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final SaveClientUseCase usecase;
    private final ClientDtoMapper mapper;

    @PostMapping
    ClientDTO newClient(@RequestBody ClientDTO clientDTO) {
        return mapper.toClientDto(usecase.saveClient(mapper.toClient(clientDTO)));
    }

//    @PostMapping
//    Client newClient(@RequestBody ClientDTO clientDTO){
//        var client = mapper.toClient(clientDTO);
//        return usecase.saveClient(client);
//    }
}
