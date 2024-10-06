package com.barreto.AmbulnzLLC_challenge.factory;

import com.barreto.AmbulnzLLC_challenge.dtos.PizzaDto;
import com.barreto.AmbulnzLLC_challenge.entites.Pizza;

import java.math.BigDecimal;
import java.util.List;

public class Factory {

    public static List<Pizza> buildListPizza() {


        var pizza1 = new Pizza(1L, "Calabresa", BigDecimal.valueOf(30));
        var pizza2 = new Pizza(2L, "Portuguesa", BigDecimal.valueOf(40));

        return List.of(pizza1, pizza2);
    }

    public static List<PizzaDto> buildListPizzaDto() {


        var pizza1 = new PizzaDto(1L, "Calabresa", BigDecimal.valueOf(30));
        var pizza2 = new PizzaDto(2L, "Portuguesa", BigDecimal.valueOf(40));

        return List.of(pizza1, pizza2);
    }

}
