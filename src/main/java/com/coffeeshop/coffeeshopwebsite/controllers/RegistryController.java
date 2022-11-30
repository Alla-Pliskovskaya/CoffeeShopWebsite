package com.coffeeshop.coffeeshopwebsite.controllers;

import com.coffeeshop.coffeeshopwebsite.models.User;
import com.coffeeshop.coffeeshopwebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistryController {
    private final UserService userService;

    @Autowired
    public RegistryController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registry")
    public String registry(Model model) {
        return "registry";
    }

    @PostMapping("/registry")
    public String doRegistry(@RequestParam String login, @RequestParam String password, @RequestParam String full_name, Model model) {
        User user = new User(login, password, full_name);
        userService.saveUser(user);
        return "redirect:/";
    }
}