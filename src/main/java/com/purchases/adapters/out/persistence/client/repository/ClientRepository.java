package com.purchases.adapters.out.persistence.client.repository;

import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
}
