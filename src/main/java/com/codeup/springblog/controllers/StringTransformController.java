package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class StringTransformController {
    @GetMapping("/string/reverse/{string}")
    //return string reversed
    @ResponseBody
    public String reverseString(@PathVariable String string){
        String reverse = "";
        for(int i = string.length() - 1; i >= 0; i--){
            reverse = reverse + string.charAt(i);
        }
        return reverse;
    }

    @GetMapping("/string/uppercase/{string}")
    @ResponseBody
    public String uppercaseString(@PathVariable String string){
        return string.toUpperCase();
    }

    @GetMapping("/string/both/{str}")
    @ResponseBody
    public String reversedToUpperCase(@PathVariable String str){
        String reverseUpper = str.toUpperCase();
        return reverseString(reverseUpper);
    }

    @GetMapping("/string/{str}")
    @ResponseBody
    public String reversedOrCapsOrBoth(
            @RequestParam String cap,
            @RequestParam String reverse,
            @PathVariable String str){

        if(reverse.equals("true")){
            return reverseString(str);
        }else if(cap.equals("true")){
           return uppercaseString(str);
        }else {
            return reversedToUpperCase(str);
        }

    }





}
