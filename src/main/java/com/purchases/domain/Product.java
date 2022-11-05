package com.purchases.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Product {

    private int id;
    private String name;
    private BigDecimal price;
    private BigDecimal quantity;
    private BigDecimal priceTotal;
    private Purchase purchase;
}
