package com.purchases.adapters.in.web.client.mapper;

import com.purchases.adapters.in.web.client.dto.ClientDTO;
import com.purchases.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientDtoMapper {

    public Client toClient(ClientDTO clientDTO) {
        return Client.builder()
                .id(clientDTO.getId())
                .name(clientDTO.getName())
                .email(clientDTO.getEmail())
                .build();
    }

    public ClientDTO toDto(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .build();
    }

    public List<ClientDTO> toDto(List<Client> clients) {
        return clients.stream()
                .map(item -> this.toDto(item))
                .collect(Collectors.toList());
    }

    public List<ClientDTO> toDto(Page<Client> clients) {
        return clients.stream()
                .map(item -> this.toDto(item))
                .collect(Collectors.toList());
    }
}
