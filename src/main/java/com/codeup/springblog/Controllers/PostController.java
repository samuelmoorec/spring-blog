package com.codeup.springblog.Controllers;

import com.codeup.springblog.Beans.User;
import com.codeup.springblog.EmailService;
import com.codeup.springblog.Beans.Post;
import com.codeup.springblog.Repositories.PostRepository;
import com.codeup.springblog.Repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
         User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newPost.setAuthor(userDao.findOne(user.getId()));
        postDao.save(newPost);
        emailService.prepareAndSend(newPost,"NEW POST","A new post was created with this email");
        return "redirect:/posts";

    }
}