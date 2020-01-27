package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DaysUntilDevDay {

    @GetMapping("/deimos")
    @ResponseBody

    public String daysUntilDevDay(){
        return "31 days until developer day.";
    }

    @GetMapping("/deimos/{days}")
    @ResponseBody

    public String daysUntilDevDay(@PathVariable String days){
        return days + " days until dev day!";
    }
}
