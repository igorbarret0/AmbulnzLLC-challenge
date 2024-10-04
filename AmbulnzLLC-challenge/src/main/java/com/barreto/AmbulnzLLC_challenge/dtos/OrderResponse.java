package com.barreto.AmbulnzLLC_challenge.dtos;

import java.math.BigDecimal;

public record OrderResponse(

        Long orderId,
        Integer quantity,
        String pizzaName,
        BigDecimal price

) {
}
