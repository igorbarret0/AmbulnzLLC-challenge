package com.barreto.AmbulnzLLC_challenge.repositories;

import com.barreto.AmbulnzLLC_challenge.entites.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
