package com.coffeeshop.coffeeshopwebsite.repositories;

import com.coffeeshop.coffeeshopwebsite.models.Bakery;
import org.springframework.data.repository.CrudRepository;

public interface BakeryRepository extends CrudRepository<Bakery, Long> {
    Bakery findByBakeryName(String bakeryName);
}


