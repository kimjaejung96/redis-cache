package com.jj.rediscache.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Food {
    private String name;
    private Integer quantity;
    private Integer price;
    private String color;
}
