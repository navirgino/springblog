package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NotMappedURIController {
    @RequestMapping(value="/**")
    public String handleNotMapped(){
        return "URI is not mapped";
    }
    @RequestMapping(value="/wildcard/**")
    public String wildCard(){
        return "wild thing";
    }
}
