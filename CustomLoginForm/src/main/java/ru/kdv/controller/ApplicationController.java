package ru.kdv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/leaders")
    public String showManagerPage(){
        return "leaders";
    }

    @GetMapping("/systems")
    public String showAdminPage(){
        return "systems";
    }
}
