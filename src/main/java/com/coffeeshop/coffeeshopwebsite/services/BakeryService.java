package com.coffeeshop.coffeeshopwebsite.services;

import com.coffeeshop.coffeeshopwebsite.models.Bakery;
import com.coffeeshop.coffeeshopwebsite.repositories.BakeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class BakeryService {
    private final BakeryRepository bakeryRepository;

    @Autowired
    public BakeryService(BakeryRepository bakeryRepository) {
        this.bakeryRepository = bakeryRepository;
    }

    public List<Bakery> getBakery() {
        List<Bakery> result = new ArrayList<>();
        bakeryRepository.findAll().forEach(result::add);
        return result;
    }

    public Bakery findByBakeryName(String bakeryName) {
        return bakeryRepository.findByBakeryName(bakeryName);
    }
}