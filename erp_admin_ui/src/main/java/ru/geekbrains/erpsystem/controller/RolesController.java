package ru.geekbrains.erpsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.erpsystem.data.RoleData;
import ru.geekbrains.erpsystem.services.RoleService;

import java.util.*;

@Controller
@RequestMapping("/roles")
public class RolesController {

    private final RoleService roleService;

    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public String showAllRoles(
            Model model
    ){
        model.addAttribute("roles", roleService.getAll() );
        return "roles";
    }

    @GetMapping("/edit/{id}")
    public String getRoleById(
            @PathVariable Long id,
            Model model
    ){
        model.addAttribute("role_name", "Edit Role");

        RoleData roleData = roleService.getById(id)
                .orElseThrow(()->new RuntimeException("Role with id - " + id + " not found"));
        model.addAttribute("roleData", roleData);
        return "forms/role_form";
    }

    @GetMapping("/add")
    public String addNewRole(
            Model model
    ){
        model.addAttribute("roleData",new RoleData());
        return "forms/role_form";
    }

    @PostMapping("/add")
    public String addAndUpdateRole(
            @ModelAttribute RoleData roleData
    ){
        if (roleData.getId() == null ){
            roleService.insert(roleData);
        }else{
            if ( roleService.getById(roleData.getId()).isEmpty() ){
                throw new RuntimeException("Role with id - " + roleData.getId() + " not found");
            }
            roleService.update(roleData);
        }

        return "redirect:all";
    }

    @GetMapping("/delete/{id}")
    public String removeRole(
            @PathVariable Long id
    ){
        roleService.delete(id);

        return "redirect:/roles/all";
    }
}
