package com.coffeeshop.coffeeshopwebsite.services;

import com.coffeeshop.coffeeshopwebsite.models.CoffeeAdditive;
import com.coffeeshop.coffeeshopwebsite.repositories.CoffeeAdditiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CoffeeAdditiveService {
    private final CoffeeAdditiveRepository coffeeAdditiveRepository;

    @Autowired
    public CoffeeAdditiveService(CoffeeAdditiveRepository coffeeAdditiveRepository) {
        this.coffeeAdditiveRepository = coffeeAdditiveRepository;
    }

    public List<CoffeeAdditive> getAdditives() {
        List<CoffeeAdditive> result = new ArrayList<>();
        coffeeAdditiveRepository.findAll().forEach(result::add);
        return result;
    }

    public CoffeeAdditive findByAdditiveName(String additiveName) {
        return coffeeAdditiveRepository.findByAdditiveName(additiveName);
    }
}
