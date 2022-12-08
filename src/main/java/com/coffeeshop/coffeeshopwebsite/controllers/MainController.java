package com.coffeeshop.coffeeshopwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("title", "Home page: Coffee Shop");
        return "main";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }
}
