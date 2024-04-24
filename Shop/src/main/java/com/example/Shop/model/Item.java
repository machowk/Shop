package com.example.Shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue  // autoinkrementacja
    private Long id;
    private String name;
    private BigDecimal price;
    private String img;

    public Item(String name, BigDecimal price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }
}
