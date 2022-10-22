package com.purchases.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {

    private int id;
    private String name;
    private Double price;
    private Double quantity;
    private Double priceTotal;
    private Purchase purchase;
}
