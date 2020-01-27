package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DaysUntilDevDay {

    @GetMapping("/deimos/{days}")
    public String daysUntilDevDay(@PathVariable String days, Model model){
        model.addAttribute("days", days);
        return "deimos.html";
    }

}
