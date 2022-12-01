package com.coffeeshop.coffeeshopwebsite.controllers;

import com.coffeeshop.coffeeshopwebsite.models.*;
import com.coffeeshop.coffeeshopwebsite.repositories.OrderRepository;
import com.coffeeshop.coffeeshopwebsite.services.BakeryService;
import com.coffeeshop.coffeeshopwebsite.services.CoffeeAdditiveService;
import com.coffeeshop.coffeeshopwebsite.services.CoffeeDrinkService;
import com.coffeeshop.coffeeshopwebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final BakeryService bakeryService;
    private final CoffeeAdditiveService coffeeAdditiveService;
    private final CoffeeDrinkService coffeeDrinkService;
    private final OrderRepository orderRepository;

    @Autowired
    public UserController(UserService userService, BakeryService bakeryService, CoffeeDrinkService coffeeDrinkService,
                           CoffeeAdditiveService coffeeAdditiveService,
                           OrderRepository orderRepository) {
        this.userService = userService;
        this.bakeryService = bakeryService;
        this.coffeeAdditiveService = coffeeAdditiveService;
        this.coffeeDrinkService = coffeeDrinkService;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/user")
    public String getCurrentUser(Principal principal, Model model) {
        if (principal == null)
            return "redirect:/login";
        User user = userService.findUserByName(principal.getName());
        model.addAttribute("username", user.getUsername());
        return "user";
    }

    @GetMapping("/user/order")
    public String order(Model model) {
        Iterable<CoffeeDrink> coffees = coffeeDrinkService.getDrinks();
        Iterable<CoffeeAdditive> additives = coffeeAdditiveService.getAdditives();
        Iterable<Bakery> bakeries = bakeryService.getBakery();
        Iterable<String> volumes = List.of(new String[]{"Маленький", "Большой"});
        model.addAttribute("coffees", coffees);
        model.addAttribute("additives", additives);
        model.addAttribute("bakeries", bakeries);
        model.addAttribute("volumes", volumes);
        return "order";
    }

    @PostMapping("/user/order")
    public String doOrder(@RequestParam String coffeeName, @RequestParam String volume,
                          @RequestParam String additiveName, @RequestParam String bakeryName, Principal principal, Model model) {
        Date date_time = new Date();
        CoffeeDrink coffeeDrink = coffeeDrinkService.findCoffeeByName(coffeeName);
        CoffeeAdditive coffeeAdditive = coffeeAdditiveService.findByAdditiveName(additiveName);
        Bakery bakery = bakeryService.findByBakeryName(bakeryName);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        User user = userService.findUserByName(principal.getName());
        Order order = new Order(coffeeDrink, volume, coffeeAdditive, bakery, formatter.format(date_time), user);
        orderRepository.save(order);
        order.getUser().getOrders().add(order);
        model.addAttribute("myOrder", order);
        model.addAttribute("username", user.getUsername());
        return "user";
    }

    @GetMapping("/user/myOrders")
    public String getMyOrders(Model model, Principal principal) {
        User user = userService.findUserByName(principal.getName());
        Iterable<Order> myOrders = user.getOrders();
        model.addAttribute("myOrders", myOrders);
        model.addAttribute("username", user.getUsername());
        return "my-orders";
    }
}
