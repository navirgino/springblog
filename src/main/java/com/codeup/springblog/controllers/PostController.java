package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping(path = "/posts")
    @ResponseBody
    public String postsIndexPage(){
        return "posts index page";
    }
    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public String viewOnePost(@PathVariable String id){
        return "view an individual post " + id;
    }

    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String formForPost(){
        return "view the form for creating a post";
    }
    @PostMapping(path = "/posts/create")
    @ResponseBody
    public String createAnewPost(){
        return "create a new post";
    }
}
