package com.jobhelp.jobapplicationhelper.controllers;

import com.jobhelp.jobapplicationhelper.models.Signup;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @GetMapping("")
    public String displaySignup(Model model) {
        model.addAttribute("signupModel", new Signup());
        return "signup";
    }

    @PostMapping("")
    public String processLogin(@Valid Signup signupModel, BindingResult bindingResult, Model model) {
        model.addAttribute("signupModel", signupModel);
        if(bindingResult.hasErrors()) {
            return "signup";
        }
        return "dev/signupResultsDevPage";
    }
}
