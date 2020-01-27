package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController {


    @GetMapping("/roll-dice")
    public String showPageToRollDice(){
        return "roll-dice";
    }

    @PostMapping("/roll-dice")
    public String rollTheDice(
            @RequestParam(name="numGuessed") Integer numGuessed, Model model){
        Random newRandom = new Random();
        model.addAttribute("numGuessed", numGuessed);
        model.addAttribute("random", newRandom.nextInt(6) + 1);

        return "roll-dice";
    }

}
