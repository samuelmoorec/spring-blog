package com.codeup.springblog.Controllers;

import com.codeup.springblog.Repositories.UserRepository;
import com.codeup.springblog.Beans.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class UserController {

    private final UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String landing(){
        return "redirect:/user/create";
    }

    @GetMapping("/user/create")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/create";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String PostId(@PathVariable long id, Model model){
        model.addAttribute("user", userDao.findOne(id));
        return "users/index";
    }

    @PostMapping("/users/create")
    public String saveUser(
            @Valid
            @ModelAttribute User user, Errors validation, Model model){
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "users/create";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }
}
