package com.coffeeshop.coffeeshopwebsite.controllers;

import com.coffeeshop.coffeeshopwebsite.models.Order;
import com.coffeeshop.coffeeshopwebsite.models.User;
import com.coffeeshop.coffeeshopwebsite.repositories.OrderRepository;
import com.coffeeshop.coffeeshopwebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;
    private final OrderRepository orderRepository;

    @Autowired
    public AdminController(UserService userService, OrderRepository orderRepository) {
        this.userService = userService;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/admin")
    public String getCurrentAdmin(Principal principal, Model model) {
        if (principal == null)
            return "redirect:/login";
        User user = userService.findUserByName(principal.getName());
        model.addAttribute("username", user.getUsername());
        return "admin";
    }

    @GetMapping("/admin/orders")
    public String watchOrders(Model model) {
        Iterable<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "all-orders";
    }

    @GetMapping("/admin/users")
    public String userSearch(Model model) {
        model.addAttribute("user", new User());
        return "user-search";
    }

    @PostMapping("/admin/users")
    public String userSearch(Model model, @RequestParam String username) {
        List<User> foundUsers = userService.foundUsers(username);
        model.addAttribute("foundUsers", foundUsers);
        return "user-search";
    }
}
