package com.purchases.adapters.out.persistence.client.repository;

import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    public Iterable<ClientEntity> findByNameContainingIgnoreCase(String partName);

    // EXEMPLO DE PESQUISA PERSONALIZADA COM QUERY
//    @Query("SELECT c FROM ClientEntity c WHERE c.name LIKE %name%")
//    public Iterable<ClientEntity> searchByName(@Param("name") String name);
}
