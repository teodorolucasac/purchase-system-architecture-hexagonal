package com.purchases.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Purchase {

    private int id;
    private String name;
    private LocalDate date;
    private Double totalValue;
    private Client client;
}
