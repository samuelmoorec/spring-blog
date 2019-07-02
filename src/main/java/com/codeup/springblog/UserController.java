package com.codeup.springblog;

import com.codeup.springblog.Repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final UserRepository userDao;

    public UserController(UserRepository userDao){
        this.userDao = userDao;
    }

    @GetMapping("/user/create")
    @ResponseBody
    public String CreateUserForm() { return "users/createuser"; }

    @PostMapping("/user/create")
    @ResponseBody
    public String CreateUser() { return "users/createuser";}

}
