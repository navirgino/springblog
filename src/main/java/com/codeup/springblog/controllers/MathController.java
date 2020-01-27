package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{number_one}/and/{number_two}")
    @ResponseBody
    public int add(@PathVariable int number_one, @PathVariable int number_two){
      int sum = number_one + number_two;
        System.out.println(sum);
      return sum;


    }
    @GetMapping("/subtract/{number_one}/from/{number_two}")
    @ResponseBody
    public int subtract(@PathVariable int number_one, @PathVariable int number_two){
        return number_one - number_two;
    }
    @GetMapping("/multiply/{num_one}/and/{num_two}")
    @ResponseBody
    public double multiply(@PathVariable double num_one, @PathVariable double num_two){
        return num_one * num_two;
    }
    @GetMapping("/divide/{n1}/by/{n2}")
    @ResponseBody
    public double divide(@PathVariable double n1, @PathVariable double n2){
        return n1 / n2;
    }
}

