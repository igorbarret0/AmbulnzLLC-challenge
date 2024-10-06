package com.barreto.AmbulnzLLC_challenge.controller;

import com.barreto.AmbulnzLLC_challenge.dtos.OrderRequest;
import com.barreto.AmbulnzLLC_challenge.dtos.OrderResponse;
import com.barreto.AmbulnzLLC_challenge.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Long> makeOrder(@RequestBody OrderRequest orderRequest) {

        var response = orderService.makeOrder(orderRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {

        var response = orderService.getAllOrders();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable(name = "orderId") Long orderId) {

        var response = orderService.getOrderById(orderId);
        return ResponseEntity.ok(response);
    }


}
