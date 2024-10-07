package com.barreto.AmbulnzLLC_challenge.service;

import com.barreto.AmbulnzLLC_challenge.dtos.OrderResponse;
import com.barreto.AmbulnzLLC_challenge.entites.Order;
import com.barreto.AmbulnzLLC_challenge.entites.OrderItem;
import com.barreto.AmbulnzLLC_challenge.factory.Factory;
import com.barreto.AmbulnzLLC_challenge.repositories.OrderItemRepository;
import com.barreto.AmbulnzLLC_challenge.repositories.OrderRepository;
import com.barreto.AmbulnzLLC_challenge.repositories.PizzaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    OrderItemRepository orderItemRepository;

    @Mock
    PizzaRepository pizzaRepository;

    @InjectMocks
    OrderService orderService;

    @Test
    @DisplayName("Should make order successfully")
    void makeOrder_Case1() {

        // Arrange
        var pizza = Factory.buildPizza();
        var orderItem = Factory.buildOrderItem();
        var order = Factory.buildOrder();
        var orderRequest = Factory.buildOrderRequest();

        when(pizzaRepository.findPizzaByName(orderRequest.pizzaName()))
                .thenReturn(Optional.of(pizza));

        when(orderItemRepository.save(any(OrderItem.class)))
                .thenAnswer(invocation -> {
                    OrderItem savedOrderItem = invocation.getArgument(0);
                    savedOrderItem.setId(orderItem.getId()); // Setando o ID após o "save"
                    return savedOrderItem;
                });

        when(orderRepository.save(any(Order.class)))
                .thenAnswer(invocation -> {
                    Order savedOrder = invocation.getArgument(0);
                    savedOrder.setId(order.getId()); // Setando o ID após o "save"
                    return savedOrder;
                });

        // Act
        var response = orderService.makeOrder(orderRequest);

        // Assert
        assertNotNull(response);
        assertEquals(order.getId(), response);
    }

    @Test
    @DisplayName("Should throw exception when pizza is not found")
    void makeOrder_Case2() {

        var orderRequest = Factory.buildOrderRequest();

        when(pizzaRepository.findPizzaByName(orderRequest.pizzaName()))
                .thenReturn(Optional.empty());

        var exception = assertThrows(RuntimeException.class, () -> {
            orderService.makeOrder(orderRequest);
        });

        assertEquals("Sorry, we don't have this flavor of pizza ", exception.getMessage());
    }

    @Test
    @DisplayName("Should return all orders when there is orders")
    void getAllOrders_Case1() {


        var orders = Factory.buildListOrder();

        when(orderRepository.findAll())
                .thenReturn(orders);

        var response = orderService.getAllOrders();

        assertNotNull(response);
        assertEquals(1L, response.getFirst().orderId());
        assertEquals(10, response.getFirst().quantity());
        assertEquals("Frango e Catupiry", response.getFirst().pizzaName());
        assertEquals(BigDecimal.valueOf(43), response.getFirst().price());

        assertEquals(2L, response.getLast().orderId());

    }

    @Test
    @DisplayName("Should return an empty list when there are no orders")
    void getAllOrders_Case2() {

        var emptyOrderList = Collections.emptyList();

        when(orderRepository.findAll())
                .thenReturn(Collections.emptyList());

        var response = orderService.getAllOrders();

        assertNotNull(response);
        assertTrue(response.isEmpty());
        assertEquals(emptyOrderList, response);

    }

    @Test
    @DisplayName("Should return a orderResponse when a ID is valid")
    void getOrderById_Case1() {

        var order = Factory.buildOrder();

        when(orderRepository.findById(order.getId()))
                .thenReturn(Optional.of(order));

        var response = orderService.getOrderById(order.getId());

        assertNotNull(response);
        assertEquals(order.getId(), response.orderId());
        assertEquals(10, response.quantity());
        assertEquals("Frango e Catupiry", response.pizzaName());
        assertEquals(BigDecimal.valueOf(43).compareTo(response.price()), 0);
    }

    @Test
    @DisplayName("Should throw an exception when try to find a Order by a invalid ID")
    void getOrderById_Case2() {

        when(orderRepository.findById(anyLong()))
                .thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            orderService.getOrderById(99L);
        });

        assertEquals("Order could not be found", exception.getMessage());

    }


}
