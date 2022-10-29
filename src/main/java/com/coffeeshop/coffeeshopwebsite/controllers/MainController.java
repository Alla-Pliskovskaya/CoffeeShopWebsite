package com.coffeeshop.coffeeshopwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("title", "Coffee Shop");
        return "main";
    }
}
