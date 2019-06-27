package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/thyme")
    public String thyme(){
        return "thyme";
    }
}
