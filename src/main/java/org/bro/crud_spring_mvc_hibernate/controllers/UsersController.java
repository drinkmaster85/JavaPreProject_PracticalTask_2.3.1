package org.bro.crud_spring_mvc_hibernate.controllers;

import org.bro.crud_spring_mvc_hibernate.models.User;
import org.bro.crud_spring_mvc_hibernate.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()//"/users"
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/all";
    }

    @GetMapping("/add")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}