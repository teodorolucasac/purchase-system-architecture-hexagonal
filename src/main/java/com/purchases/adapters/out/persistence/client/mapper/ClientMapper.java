package com.purchases.adapters.out.persistence.client.mapper;

import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import com.purchases.domain.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toClient(ClientEntity clientEntity) {
        return Client.builder()
                .name(clientEntity.getName())
                .email(clientEntity.getEmail())
                .build();
    }

    public ClientEntity toClientEntity(Client client) {
        return ClientEntity.builder()
                .name(client.getName())
                .email(client.getEmail())
                .build();
    }
}
