package com.barreto.AmbulnzLLC_challenge.entites;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;


@Entity
@Table(name = "tb_order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    private Integer quantity;

    @OneToMany(mappedBy = "orderItem", cascade = CascadeType.ALL)
    private List<Order> orders;

    public OrderItem() {}

    public OrderItem(Long id, Pizza pizza, Integer quantity, List<Order> order) {
        this.id = id;
        this.pizza = pizza;
        this.quantity = quantity;
        this.orders = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
