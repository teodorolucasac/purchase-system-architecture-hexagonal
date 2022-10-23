package com.purchases.adapters.in.web.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDTO {

    private int id;
    private String name;
    private Double price;
    private Double quantity;
    private Double priceTotal;
    private int purchaseId;
}
