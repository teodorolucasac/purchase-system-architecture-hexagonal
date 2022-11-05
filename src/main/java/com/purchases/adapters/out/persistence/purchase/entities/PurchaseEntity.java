package com.purchases.adapters.out.persistence.purchase.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.purchases.adapters.out.persistence.client.entities.ClientEntity;
import com.purchases.adapters.out.persistence.product.entities.ProductEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
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
    @NotBlank
    private String name;
    private LocalDate date;
    private BigDecimal totalValue;

    @NotNull(message = "ERRO. Vincule a compra à um client.")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<ProductEntity> product;
}
