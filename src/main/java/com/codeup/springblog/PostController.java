package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String Post() {
        return "posts index page";
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String PostId(@PathVariable Long id){
        return "Showing post " + id + ".";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String CreatePostForm() {
        return "You Create Post here.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String CreatePost() {
        return "Submit Form with this";
    }
}