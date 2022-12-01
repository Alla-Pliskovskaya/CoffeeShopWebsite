package com.coffeeshop.coffeeshopwebsite.controllers;

import com.coffeeshop.coffeeshopwebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class MainController {
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("title", "Home page: Coffee Shop");
        return "main";
    }

    @GetMapping("/403")
    public String error403(Model model,Principal principal) {
        if (principal != null)
        {
            var user = userService.findUserByName(principal.getName());
            model.addAttribute("user", user);

            String message = "Hi, " + principal.getName() //
                    + ",<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }

        return "error/403";
    }
}
