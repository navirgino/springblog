package com.codeup.springblog.controllers;


import com.codeup.springblog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping(path = "/posts")
    public String postsIndexPage(Model model){

        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("titl1", "body1");
        Post post2 = new Post("titl2", "body2");
        Post post3 = new Post("titl3", "body3");
        Post post4 = new Post("titl4", "body4");
        posts.add(0, post1);
        posts.add(1, post2);
        posts.add(2, post3);
        posts.add(3, post4);
        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping(path = "/posts/show")
    public String viewOnePost(Model model)
    {
        Post newPost = new Post("my tweet", "banana time");
        model.addAttribute("newPost", newPost);
        return "posts/show";
    }

//    @GetMapping(path ="/posts/{id}")
//    public String getPostById(@PathVariable String id){
//        List<Post> posts = new ArrayList<>();
//        Post onePost = new Post(1, "one", "one");
//        Post twoPost = new Post(2, "two", "two");
//        Post threePost = new Post(3, "three", "three");
//        posts.add(0, onePost);
//        posts.add(1, twoPost);
//        posts.add(2, threePost);
//        return "posts/index";
//
//    }

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
