package com.tsayun.coffemachine.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private BigDecimal price;
    private Float storedQuantity;
    private String name;

}
