package com.barreto.AmbulnzLLC_challenge.repositories;

import com.barreto.AmbulnzLLC_challenge.entites.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    Optional<Pizza> findPizzaByName(String name);

}
