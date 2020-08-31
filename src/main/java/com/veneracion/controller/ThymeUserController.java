package com.veneracion.controller;

import com.veneracion.models.User;
import com.veneracion.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeUserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/subscribe")
    public String showUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @PostMapping("/subscribe")
    public String addUser(@ModelAttribute("user") User user){
        userRepository.save(user);
        return "thankyou";
    }

    @PostMapping("/unsubscribe")
    public String removeUser(@ModelAttribute("user") User user){
        userRepository.delete(user);
        return "unsub";
    }
}