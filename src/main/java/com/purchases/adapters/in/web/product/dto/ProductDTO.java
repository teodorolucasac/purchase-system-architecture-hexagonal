package com.purchases.adapters.in.web.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProductDTO {

    private int id;
    private String name;
    private BigDecimal price;
    private BigDecimal quantity;
    private BigDecimal priceTotal;
    private int purchaseId;
}
