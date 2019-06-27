package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


        @GetMapping("/posts")
        public String index(Model model) {
            model.addAttribute("posts", postDao.findAll());
            return "posts/index";
        }

        @DeleteMapping("/posts/delete/{id}")
        void deletebyid(@PathVariable Long id) {
            model.addAttribute("posts", postDao.delete());

        }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)

    public String PostId(@PathVariable int id, ArrayList<Person> people, Model model){

        people.add(new Person("lol", "I hate good coffee"));
        people.add(new Person("coffee", "Coffeee is the besssst"));
        people.add(new Person("Candy is good", "Your not yourself without a snickers"));
        model.addAttribute("posts", people.get(id));
        return "posts/index";
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