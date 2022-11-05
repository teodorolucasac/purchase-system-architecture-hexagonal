package com.purchases.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Purchase {

    private int id;
    private String name;
    private LocalDate date;
    private BigDecimal totalValue;
    private Client client;
}
