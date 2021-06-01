package ru.geekbrains.erpsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.erpsystem.data.RoleData;
import ru.geekbrains.erpsystem.data.UserData;
import ru.geekbrains.erpsystem.services.RoleService;
import ru.geekbrains.erpsystem.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public String showAllUsers(
            Model model
    ){
        model.addAttribute("users", userService.getAll() );
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String getUserById(
            @PathVariable Long id,
            Model model
    ){
        UserData userData = userService.getById(id)
                .orElseThrow(()->new RuntimeException("user with id - " +id+ "not found"));
        model.addAttribute("userData", userData);

        model.addAttribute("allRoles", roleService.getAll() );
        return "forms/edit_user_form";
    }

    @GetMapping("/add")
    public String addNewUser(
            Model model
    ){
        model.addAttribute("userData",new UserData());
        model.addAttribute("allRoles", roleService.getAll() );
        return  "forms/add_user_form";
    }

    @PostMapping("/add")
    public String addAndUpdateUser(
            @ModelAttribute UserData userData
    ){
        if (userData.getId() == null){
            userService.insert(userData);
        }else {
            if ( userService.getById(userData.getId()).isEmpty() ){
                throw new RuntimeException("User with id - "+userData.getId()+ "not found");
            }
            Long selectRoleId = userData.getRoleData().getId();
            RoleData selectRole = roleService.getById(selectRoleId)
                    .orElseThrow(()->new RuntimeException("Role with id - " +selectRoleId+" not found"));

            userData.setRoleData(selectRole);

            userService.update(userData);
        }
        return "redirect:all";
    }


    @GetMapping("delete/{id}")
    public String deleteUserById(
            @PathVariable Long id,
            Model model
    ){
        userService.getById(id)
                .orElseThrow(()->new RuntimeException("user with id - "+id+" not found"));

        userService.delete(id);

        return "redirect:/users/all";
    }


}
