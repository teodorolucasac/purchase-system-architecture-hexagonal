package com.purchases.adapters.in.web.client.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientDTO {

    private int id;
    private String name;
    private String email;
}
