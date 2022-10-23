package com.purchases.adapters.in.web.client.mapper;

import com.purchases.adapters.in.web.client.dto.ClientDTO;
import com.purchases.domain.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoMapper {

    public Client toClient(ClientDTO clientDTO) {
        return Client.builder()
                .id(clientDTO.getId())
                .name(clientDTO.getName())
                .email(clientDTO.getEmail())
                .build();
    }

    public ClientDTO toClientDto(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .build();
    }
}
