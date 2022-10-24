package com.purchases.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Client {

    private int id;
    private String name;
    private String email;
}
