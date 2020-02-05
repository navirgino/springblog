package com.codeup.springblog.controllers;


import com.codeup.springblog.Post;
import com.codeup.springblog.PostImage;
import com.codeup.springblog.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class PostController {

    private PostRepository postsDao;
    private UserRepository userDao;
    private final EmailService emailService;


    public PostController(PostRepository postsDao,
                          UserRepository userDao,
                          EmailService emailService) {
        this.postsDao = postsDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }
    /////////////////////////////////////////////////


    @GetMapping(path = "/posts")
    public String allPosts(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping(path = "/posts/jpa")
    @ResponseBody
    public List<Post> returnPosts() {
        return postsDao.findAll();
    }


    //delete
    @PostMapping(path = "/posts/{id}/delete")
    public String deletePostById(@PathVariable long id) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }


    //    return a simple view that displays a given post's historyOfPost detail
    @GetMapping(path = "posts/{id}/history")
    public String historyOfPost(@PathVariable long id, Model m) {
        m.addAttribute("post", postsDao.findById(id));

        return "posts/history";

    }

    @GetMapping(path = "/posts/{id}/showImg")
    public String getImageById(@PathVariable long id, Model m) {
        m.addAttribute("post", postsDao.findById(id));
        return "posts/image";
    }


    @GetMapping(path = "/posts/create")
    public String createAndGetFormForPost(Model m) {
        m.addAttribute("post", new Post());
        return "posts/create";

    }

    @PostMapping(path = "/posts/create")
    public String createAndPostFormForPost(@ModelAttribute Post post)
    {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postsDao.save(post);
        emailService.prepareAndSend(post, "subject", "body - hello");
        return "redirect:/posts";
    }

    @GetMapping(path = "/posts/{id}/update")
    public String updateAndGetFormForPost(Model m, @PathVariable long id) {
        m.addAttribute("post", postsDao.getOne(id));
        return "posts/update";

    }

    @PostMapping(path = "/posts/{id}/update")
    public String updateAndPostFormForPost(@ModelAttribute Post post, @PathVariable String id) {
        postsDao.save(post);
        return "redirect:/posts";
    }


}
