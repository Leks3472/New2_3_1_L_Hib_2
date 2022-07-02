package ru.leks3472.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HelloController {
    @GetMapping("/hello-world")
    public String sayHello() {
        return "/hello-world";
    }

    @GetMapping("/hello")
    public String HelloP() {
        return "/hello";
    }

    @GetMapping("/goodbye")
    public String goodByeP() {
        return "/goodbye";
    }
}
