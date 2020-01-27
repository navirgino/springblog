package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JoinController {

    @GetMapping("/join")
    public String showJoinForm(){
        return "join.html";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name="cohort") String cohort, Model model){
        model.addAttribute("cohort", "welcome to the " + cohort + " club");
        return "join.html";
    }

}
