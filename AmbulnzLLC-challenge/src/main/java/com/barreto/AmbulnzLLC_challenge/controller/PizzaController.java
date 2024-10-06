package com.barreto.AmbulnzLLC_challenge.controller;

import com.barreto.AmbulnzLLC_challenge.dtos.PizzaDto;
import com.barreto.AmbulnzLLC_challenge.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    private PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaDto>> getAllPizzas() {

        var response = pizzaService.getAllPizzas();

        return ResponseEntity.ok(response);
    }

}
