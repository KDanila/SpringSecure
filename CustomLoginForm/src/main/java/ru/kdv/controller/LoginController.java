package ru.kdv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showLoginForm")
    public String showLoginForm() {
        return "bootstrap-login";
    }

    @GetMapping("/access-denied")
    public String showDeniedForm() {
        return "access-denied";
    }
}
