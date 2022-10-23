package com.purchases.adapters.in.web.purchase.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PurchaseDTO {

    private int id;
    private String name;
    private LocalDate date;
    private Double totalValue;
    private int clientId;
}
