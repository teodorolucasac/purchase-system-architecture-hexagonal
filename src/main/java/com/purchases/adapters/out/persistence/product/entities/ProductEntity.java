package com.purchases.adapters.out.persistence.product.entities;

import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "tb_product")
public class ProductEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private int id;
    private String name;
    private Double price;
    private Double quantity;
    private Double priceTotal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_id")
    private PurchaseEntity purchase;
}
