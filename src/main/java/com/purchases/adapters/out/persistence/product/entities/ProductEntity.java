package com.purchases.adapters.out.persistence.product.entities;

import com.purchases.adapters.out.persistence.purchase.entities.PurchaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_product")
public class ProductEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private int id;
    @NotBlank
    private String name;
    @Min(0)
    private BigDecimal price;
    @Min(0)
    private BigDecimal quantity;
    private BigDecimal priceTotal;

    @NotNull(message = "ERRO. Vincule o produto à uma compra.")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "purchase_id")
    private PurchaseEntity purchase;
}
