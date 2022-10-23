package com.purchases.adapters.out.persistence.client.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_client")
public class ClientEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<PurchaseEntity> purchase;
}
