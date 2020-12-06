package com.tsayun.coffemachine.bean;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Drink implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private long price;
    private String name;
    private Map<Ingredient, Float> ingredientToQuantity;
}
