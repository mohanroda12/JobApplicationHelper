package com.jobhelp.jobapplicationhelper.controllers;

import com.jobhelp.jobapplicationhelper.entities.UserEntity;
import com.jobhelp.jobapplicationhelper.models.Signup;
import com.jobhelp.jobapplicationhelper.services.UserServiceInterface;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    public final UserServiceInterface userService;

    public SignupController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String displaySignup(Model model) {
        model.addAttribute("user", new UserEntity());
        return "signup";
    }

    @PostMapping("")
    public String processLogin(@Valid @ModelAttribute("user")UserEntity user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "signup";
        }
        userService.registerUser(user);
        return "redirect:/login";
    }
}

