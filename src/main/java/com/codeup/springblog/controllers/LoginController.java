package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginForm(){
        return "login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name="username") String username,
                        @RequestParam(name="password") String password,
                        Model model)
    {
        ArrayList<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("Apples");
        shoppingCart.add("Ban");
        shoppingCart.add("na");
        shoppingCart.add("na");

        boolean isAdmin = true;
        model.addAttribute("shoppingCart", shoppingCart);
        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("username","this is your username: " + username);
        model.addAttribute("password","this is your password: " + password);
        return "profile.html";
    }
}
