package com.purchases.adapters.out.persistence.client.repository;

import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
