package com.barreto.AmbulnzLLC_challenge.service;

import com.barreto.AmbulnzLLC_challenge.dtos.OrderRequest;
import com.barreto.AmbulnzLLC_challenge.dtos.OrderResponse;
import com.barreto.AmbulnzLLC_challenge.entites.Order;
import com.barreto.AmbulnzLLC_challenge.entites.OrderItem;
import com.barreto.AmbulnzLLC_challenge.repositories.OrderItemRepository;
import com.barreto.AmbulnzLLC_challenge.repositories.OrderRepository;
import com.barreto.AmbulnzLLC_challenge.repositories.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    private PizzaRepository pizzaRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, PizzaRepository pizzaRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.pizzaRepository = pizzaRepository;
    }

    public Long makeOrder(OrderRequest orderRequest) {

        var pizza = pizzaRepository.findPizzaByName(orderRequest.pizzaName())
                .orElseThrow(() -> new RuntimeException("Sorry, we don't have this flavor of pizza "));

        var orderItem = new OrderItem();
        orderItem.setPizza(pizza);
        orderItem.setQuantity(orderRequest.quantity());

        var orderItemSaved = orderItemRepository.save(orderItem);

        var order = new Order();
        order.setOrderItem(orderItemSaved);

        var orderSaved = orderRepository.save(order);

        return order.getId();
    }

    public List<OrderResponse> getAllOrders() {

        var allOrders = orderRepository.findAll();

        var response = allOrders.stream()
                .map(
                        order -> new OrderResponse(
                                order.getId(),
                                order.getOrderItem().getQuantity(),
                                order.getOrderItem().getPizza().getName(),
                                order.getOrderItem().getPizza().getPrice()
                        )
                ).toList();

        return response;
    }

    public OrderResponse getOrderById(Long orderId) {

        var order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order could not be found"));

        return new OrderResponse(
                order.getId(),
                order.getOrderItem().getQuantity(),
                order.getOrderItem().getPizza().getName(),
                order.getOrderItem().getPizza().getPrice()
        );
    }
}
