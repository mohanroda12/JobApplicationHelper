package com.jobhelp.jobapplicationhelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage() {
        return "home.html";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login.html";
    }

    @RequestMapping("/signup")
    public String signUp() {
        return "signup.html";
    }
}
