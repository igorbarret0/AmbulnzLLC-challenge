package com.barreto.AmbulnzLLC_challenge.factory;

import com.barreto.AmbulnzLLC_challenge.dtos.OrderRequest;
import com.barreto.AmbulnzLLC_challenge.dtos.OrderResponse;
import com.barreto.AmbulnzLLC_challenge.dtos.PizzaDto;
import com.barreto.AmbulnzLLC_challenge.entites.Order;
import com.barreto.AmbulnzLLC_challenge.entites.OrderItem;
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

    public static Pizza buildPizza() {

        return new Pizza(
                1L,
                "Frango e Catupiry",
                BigDecimal.valueOf(43)
        );
    }

    public static OrderItem buildOrderItem() {


        var orderItem = new OrderItem();
        orderItem.setId(1L);
        orderItem.setPizza(buildPizza());
        orderItem.setQuantity(10);

        return orderItem;
    }

    public static Order buildOrder() {

        return new Order(
                1L,
                buildOrderItem()
        );
    }

    public static OrderRequest buildOrderRequest() {

        return new OrderRequest(
          "Frango e Catupiry",
                10
        );
    }

    public static List<Order> buildListOrder() {

        var order1 = new Order(1L, buildOrderItem());
        var order2 = new Order(2L, buildOrderItem());

        return List.of(order1, order2);
    }


}
