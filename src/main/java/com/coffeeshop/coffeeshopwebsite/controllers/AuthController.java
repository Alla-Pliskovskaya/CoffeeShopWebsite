package com.coffeeshop.coffeeshopwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController
{
    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/user")
    public String user(Model model) {
        return "user";
    }

    @GetMapping("/403")
    public String error403(Model model) {
        return "error/403";
    }
}
