package com.jobhelp.jobapplicationhelper.controllers;

import com.jobhelp.jobapplicationhelper.models.Login;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String displayLogin(Model model) {
        model.addAttribute("loginModel", new Login());
        return "login";
    }

    @PostMapping("")
    public String processLogin(@Valid Login loginModel, BindingResult bindingResult, Model model) {
        model.addAttribute("loginModel", loginModel);
        if(bindingResult.hasErrors()) {
            return "login";
        }
        return "dev/loginResultsDevPage";
    }
}
