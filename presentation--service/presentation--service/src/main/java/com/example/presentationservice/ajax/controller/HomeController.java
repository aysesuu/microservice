package com.example.presentationservice.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class HomeController {
    @GetMapping("/home")
    public String index(){
        return "index";
    }
}
