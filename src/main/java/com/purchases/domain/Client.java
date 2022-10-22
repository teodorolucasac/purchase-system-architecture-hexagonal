package com.purchases.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Client {

    private int id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
