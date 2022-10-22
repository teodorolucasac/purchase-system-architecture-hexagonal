package com.purchases.adapters.out.persistence.client.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import com.purchases.domain.Purchase;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name = "tb_client")
public class ClientEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;


    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<PurchaseEntity> purchase;
}
