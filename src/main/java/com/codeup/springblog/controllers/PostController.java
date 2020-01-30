package com.codeup.springblog.controllers;


import com.codeup.springblog.Post;
import com.codeup.springblog.PostImage;
import com.codeup.springblog.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;

    public PostController(PostRepository postsDao,
                          UserRepository userDao)
    {
        this.postsDao = postsDao;
        this.usersDao = userDao;
    }
    /////////////////////////////////////////////////


    @GetMapping(path = "/posts")
    public String allPosts(Model model) {
        model.addAttribute("posts", returnPosts());
        return "posts/index";
    }

    @GetMapping(path = "/posts/jpa")
    @ResponseBody
    public List<Post> returnPosts() {
        return postsDao.findAll();
    }

    //get post info
    @GetMapping(path = "/posts/update")
    public String GetPostFormFromUpdateForm(@RequestParam long id,
                                            @RequestParam String title,
                                            @RequestParam String body,
                                            Model m) {
        m.addAttribute("title", title);
        m.addAttribute("body", body);
        m.addAttribute("id", id);

        return "posts/update";
    }

    //return post info
    @PostMapping(path = "/posts/update")
    public String ReturnUpdatedPostForm(@RequestParam long id,
                                        @RequestParam String title,
                                        @RequestParam String body,
                                        Model m) {
        m.addAttribute("id", id);
        m.addAttribute("title", title);
        m.addAttribute("body", body);
        Post updatedPost = new Post(id, title, body);
        postsDao.save(updatedPost);
        return "redirect:/posts";
    }


    //delete
    @PostMapping(path = "/posts/{id}/delete")
    public String deletePostById(@PathVariable long id)
    {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }


//    return a simple view that displays a given post's historyOfPost detail
    @GetMapping(path = "posts/{id}/history")
    public String historyOfPost(@PathVariable long id, Model m)
    {
        m.addAttribute("post", postsDao.findById(id));

        return "posts/history";

    }




    @GetMapping(path = "/posts/{id}/showImg")
    public String getImageById(@PathVariable long id, Model m)
    {
        m.addAttribute("post", postsDao.findById(id));
        return "posts/image";
    }

//    @GetMapping("/posts/jpa/create")
//    public void createPost()
//    {
//        Post post = new Post();
//        User user = new User();
//
//        post.setTitle("a new post");
//        post.setBody("a new body");
//        post.setUser(user);
//        postsDao.save(post);
//    }



//
//    @GetMapping("posts/order")
//    public String searchResults(Model model){
//        model.addAttribute("searchResults", returnPostsByTitle());
//        return "posts/results";
//    }
//
//    @GetMapping("posts/order/jpa")
//    @ResponseBody
//    public Post returnPostsByTitle()
//    {
//        return postsDao.findByTitle("t");
//    }

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
