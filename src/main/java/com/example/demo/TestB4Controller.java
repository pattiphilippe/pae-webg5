package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestB4Controller{

    @GetMapping("/testb4")
    public String home(Model model){
        return "test";
    }

}