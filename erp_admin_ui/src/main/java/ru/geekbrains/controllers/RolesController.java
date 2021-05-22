package ru.geekbrains.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/roles")
public class RolesController {

    @GetMapping("/all")
    public String showAllRoles(
            Model model
    ){

        return "roles";
    }
}
