package com.tsayun.coffemachine.bean;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrinkToOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private BigDecimal price;
    private String name;
    private Long quantity;
    private Map<Ingredient, Float> ingredientToQuantity;
}
