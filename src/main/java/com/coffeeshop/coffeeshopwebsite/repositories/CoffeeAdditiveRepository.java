package com.coffeeshop.coffeeshopwebsite.repositories;

import com.coffeeshop.coffeeshopwebsite.models.CoffeeAdditive;
import com.coffeeshop.coffeeshopwebsite.models.CoffeeDrink;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeAdditiveRepository extends CrudRepository<CoffeeAdditive, Long> {
    CoffeeAdditive findByAdditiveName(String additiveName);
}
