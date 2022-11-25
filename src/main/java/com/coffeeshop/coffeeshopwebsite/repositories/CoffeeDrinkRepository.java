package com.coffeeshop.coffeeshopwebsite.repositories;

import com.coffeeshop.coffeeshopwebsite.models.CoffeeDrink;
import com.coffeeshop.coffeeshopwebsite.models.User;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeDrinkRepository extends CrudRepository<CoffeeDrink, Long> {
    CoffeeDrink findByCoffeeName(String coffeeName);
}
