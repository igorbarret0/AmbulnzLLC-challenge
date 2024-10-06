package com.barreto.AmbulnzLLC_challenge.service;

import com.barreto.AmbulnzLLC_challenge.entites.Pizza;
import com.barreto.AmbulnzLLC_challenge.factory.Factory;
import com.barreto.AmbulnzLLC_challenge.mapper.PizzaMapper;
import com.barreto.AmbulnzLLC_challenge.repositories.PizzaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PizzaServiceTest {

    @Mock
    private PizzaRepository pizzaRepository;

    @Mock
    private PizzaMapper pizzaMapper;

    @InjectMocks
    private PizzaService pizzaService;

    @Test
    @DisplayName("Should return a list of pizzas when there is pizza")
    void getAllPizzas_Case1() {

        // Arrange
        var pizzas = Factory.buildListPizza();
        var pizzaDtos = Factory.buildListPizzaDto();

        // Mockando o comportamento do repositório e do mapper
        when(pizzaRepository.findAll()).thenReturn(pizzas);

        when(pizzaMapper.toPizzaDto(any(Pizza.class)))
                .thenAnswer(invocation -> {
                    Pizza pizza = invocation.getArgument(0);
                    return pizzaDtos.stream()
                            .filter(dto -> dto.id().equals(pizza.getId()))
                            .findFirst().orElse(null);
                });

        // Act
        var result = pizzaService.getAllPizzas();

        // Assert
        assertNotNull(result);
        assertEquals(pizzaDtos.size(), result.size());
        assertEquals(pizzaDtos, result);
    }

    @Test
    @DisplayName("Should return an empty list when there are no pizzas")
    void getAllPizzas_Case2() {

        // Arrange
        var emptyPizzaDtoList = Collections.emptyList();

        when(pizzaRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        var result = pizzaService.getAllPizzas();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        assertEquals(emptyPizzaDtoList, result);
    }


}
