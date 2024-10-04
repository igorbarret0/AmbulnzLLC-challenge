package com.barreto.AmbulnzLLC_challenge.service;

import com.barreto.AmbulnzLLC_challenge.dtos.PizzaDto;
import com.barreto.AmbulnzLLC_challenge.mapper.PizzaMapper;
import com.barreto.AmbulnzLLC_challenge.repositories.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    private PizzaRepository pizzaRepository;
    private PizzaMapper pizzaMapper;

    public PizzaService (PizzaRepository pizzaRepository, PizzaMapper pizzaMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
    }

    public List<PizzaDto> getAllPizzas() {

        var allPizzas = pizzaRepository.findAll();

        return allPizzas.stream().map(
                pizza -> pizzaMapper.toPizzaDto(pizza))
                .collect(Collectors.toList());

    }

}
