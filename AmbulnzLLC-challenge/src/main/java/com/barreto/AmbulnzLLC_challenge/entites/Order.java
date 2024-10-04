package com.barreto.AmbulnzLLC_challenge.entites;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    public Order() {}

    public Order(Long id, OrderItem orderItems) {
        this.id = id;
        this.orderItem = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
