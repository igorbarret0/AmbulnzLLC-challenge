package com.barreto.AmbulnzLLC_challenge.mapper;

import com.barreto.AmbulnzLLC_challenge.dtos.PizzaDto;
import com.barreto.AmbulnzLLC_challenge.entites.Pizza;
import org.springframework.stereotype.Component;

@Component
public class PizzaMapper {

    public PizzaDto toPizzaDto(Pizza pizza) {

        var pizzaDto = new PizzaDto(
                pizza.getId(),
                pizza.getName(),
                pizza.getPrice()
        );

        return pizzaDto;

    }

}
