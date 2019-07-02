package com.codeup.springblog;

import com.codeup.springblog.Repositories.PostRepository;
import com.codeup.springblog.Repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


        @GetMapping("/posts")
        public String index(Model model) {
            model.addAttribute("posts", postDao.findAll());

            return "posts/index";
        }

//        @DeleteMapping("/posts/delete/{id}")
//        void deletebyid(@PathVariable Long id, Model model) {
//            Model posts = model.addAttribute("posts", postDao.delete(id));
//
//        }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)

    public String PostId(@PathVariable int id, ArrayList<Post> posts, Model model){

//        posts.add(new Post("lol", "I hate good coffee"));
//        posts.add(new Post("coffee", "Coffeee is the besssst"));
//        posts.add(new Post("Candy is good", "Your not yourself without a snickers"));
//        User bob = new User("Bob234","bobiscool@gmail.com","pass", posts);

        model.addAttribute("posts", posts.get(id));
        return "posts/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String CreateEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", postDao.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String EditExisting(@ModelAttribute Post newPost) {
        postDao.save(newPost);
        return "redirect:/posts";

    }

    @GetMapping("/posts/create")
    public String CreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String Insert(@ModelAttribute Post newPost) {

        postDao.save(newPost);
        return "redirect:/posts";

    }
}