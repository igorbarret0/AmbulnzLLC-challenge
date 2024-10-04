package com.barreto.AmbulnzLLC_challenge.dtos;

import java.math.BigDecimal;

public record PizzaDto(
        Long id,
        String name,
        BigDecimal price
) {
}
