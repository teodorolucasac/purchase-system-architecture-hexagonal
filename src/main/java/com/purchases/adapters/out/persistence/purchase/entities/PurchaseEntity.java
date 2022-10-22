package com.purchases.adapters.out.persistence.purchase.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import com.purchases.adapters.out.persistence.product.entities.ProductEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_purchase")
public class PurchaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private int id;
    private String name;
    private LocalDate date;
    private Double totalValue;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @OneToMany(mappedBy = "purchase")
    @JsonIgnore
    private List<ProductEntity> product;
}
