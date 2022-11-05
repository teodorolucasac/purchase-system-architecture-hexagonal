package com.purchases.adapters.out.persistence.client.mapper;

import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import com.purchases.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public ClientEntity toClientEntity(Client client) {
        return ClientEntity.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .build();
    }

    public Client toClient(ClientEntity clientEntity) {
        return Client.builder()
                .id(clientEntity.getId())
                .name(clientEntity.getName())
                .email(clientEntity.getEmail())
                .build();
    }

    public Client toClient(Optional<ClientEntity> clientEntity) {
        return Client.builder()
                .id(clientEntity.get().getId())
                .name(clientEntity.get().getName())
                .email(clientEntity.get().getEmail())
                .build();
    }

    public List<Client> toClient(List<ClientEntity> clientEntities) {
        return clientEntities.stream()
                .map(item -> Client.builder()
                        .id(item.getId())
                        .email(item.getEmail())
                        .name(item.getName())
                        .build())
                .collect(Collectors.toList());
    }

    public List<Client> toClient(Page<ClientEntity> clientEntities) {
        return clientEntities.stream()
                .map(item -> this.toClient(item))
                .collect(Collectors.toList());
    }
}
