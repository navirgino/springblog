package com.codeup.springblog.controllers;


import com.codeup.springblog.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private List<Post> posts = new ArrayList<>();

    private PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String allPosts(Model model){
        model.addAttribute("posts", returnPosts());
        return "posts/index";
    }

    @GetMapping("/posts/jpa")
    @ResponseBody
    public List<Post> returnPosts(){
        return postsDao.findAll();
    }


//
//    @PostMapping(path = "/posts/create")
//    @ResponseBody
//    public String createAnewPost(){
//        Post post = new Post();
//        post.setTitle("A new post!");
//        post.setBody("A new body!");
//        return "create a new post";
//    }

    @GetMapping("/posts/jpa/create")
    public void createPost() {
        Post post = new Post();
        post.setTitle("a new post");
        post.setBody("a new body");
        postsDao.save(post);
    }

    @GetMapping("posts/order")
    public String searchResults(Model model){
        model.addAttribute("searchResults", returnPostsByTitle());
        return "posts/results";
    }

    @GetMapping("posts/order/jpa")
    @ResponseBody
    public Post returnPostsByTitle()
    {
        return postsDao.findByTitle("t");
    }

//    @GetMapping("/posts/search")
//    @ResponseBody
//    public Post returnPostByTitle()
//    {
//        return postsDao.findByTitle("t");
//    }


//    @GetMapping(path = "/posts/show")
//    public String viewOnePost(Model model)
//    {
//        Post newPost = new Post("my tweet", "banana time");
//        model.addAttribute("newPost", newPost);
//        return "posts/show";
//    }


//    @GetMapping("/posts/{id}")
//    public String viewOnePostById(@PathVariable long id, Model model)
//    {
//        Post post1 = new Post(id,"Title 1", "Description 1");
//        Post post2 = new Post(id,"Title 2", "Description 2");
//        model.addAttribute("post1", post1);
//        model.addAttribute("post2",post2);
//        return "posts/show";
//    }


}
