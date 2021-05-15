package ru.geekbrains.controller;

import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    public String greet() {
        return "greet";
    }

}
