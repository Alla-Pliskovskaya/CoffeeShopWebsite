package com.coffeeshop.coffeeshopwebsite.services;

import com.coffeeshop.coffeeshopwebsite.models.CoffeeDrink;
import com.coffeeshop.coffeeshopwebsite.repositories.CoffeeDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CoffeeDrinkService {
    private final CoffeeDrinkRepository coffeeDrinkRepository;

    @Autowired
    public CoffeeDrinkService(CoffeeDrinkRepository coffeeDrinkRepository) {
        this.coffeeDrinkRepository = coffeeDrinkRepository;
    }

    public List<CoffeeDrink> getDrinks() {
        List<CoffeeDrink> result = new ArrayList<>();
        coffeeDrinkRepository.findAll().forEach(result::add);
        return result;
    }

    public CoffeeDrink findCoffeeByName(String coffeeName) {
        return coffeeDrinkRepository.findByCoffeeName(coffeeName);
    }
}
