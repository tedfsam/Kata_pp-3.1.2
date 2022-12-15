package com.kata.crud.pp312.controller;

import com.kata.crud.pp312.model.User;
import com.kata.crud.pp312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUser(Model model) {
        model.addAttribute("alluser", userService.getAllUser());
        return "users/all-user";
    }

    @GetMapping("/{id}")
    public String oneUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getOneUser(id));
        return "users/one-user";
    }

    @GetMapping("/addnew")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new-user";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getOneUser(id));
        return "users/edit-user";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
