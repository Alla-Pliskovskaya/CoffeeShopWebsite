package com.coffeeshop.coffeeshopwebsite.controllers;

import com.coffeeshop.coffeeshopwebsite.models.Bakery;
import com.coffeeshop.coffeeshopwebsite.models.CoffeeAdditive;
import com.coffeeshop.coffeeshopwebsite.models.CoffeeDrink;
import com.coffeeshop.coffeeshopwebsite.services.BakeryService;
import com.coffeeshop.coffeeshopwebsite.services.CoffeeAdditiveService;
import com.coffeeshop.coffeeshopwebsite.services.CoffeeDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {
    private final CoffeeDrinkService coffeeDrinkService;
    private final CoffeeAdditiveService coffeeAdditiveService;
    private final BakeryService bakeryService;

    @Autowired
    public MenuController(CoffeeDrinkService coffeeDrinkService,
                          CoffeeAdditiveService coffeeAdditiveService,
                          BakeryService bakeryService) {
        this.coffeeDrinkService = coffeeDrinkService;
        this.coffeeAdditiveService = coffeeAdditiveService;
        this.bakeryService = bakeryService;
    }

    @GetMapping("/menu")
    public String getMenu(Model model) {
        model.addAttribute("title", "Menu");
        return "menu";
    }

    @GetMapping("/menu/drinks")
    public String getDrinksMenu(Model model) {
        List<CoffeeDrink> drinks = coffeeDrinkService.getDrinks();
        List<CoffeeAdditive> additives = coffeeAdditiveService.getAdditives();
        model.addAttribute("drinks", drinks);
        model.addAttribute("additives", additives);
        return "drinks";
    }

    @GetMapping("/menu/bakery")
    public String getBakeryMenu(Model model) {
        List<Bakery> bakery = bakeryService.getBakery();
        model.addAttribute("bakery", bakery);
        return "bakery";
    }
}
