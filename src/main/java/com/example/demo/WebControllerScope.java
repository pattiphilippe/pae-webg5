package com.example.demo;

import com.example.demo.business.IDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebControllerScope{

    @Autowired
    IDGenerator requestBean;

    @Autowired
    IDGenerator sessionBean;

    @Autowired
    IDGenerator singletonBean;

    @Autowired
    IDGenerator defaultBean;

    @GetMapping("/scopetest")
    public String test(Model model){
        model.addAttribute("requestBean", requestBean.getId());
        model.addAttribute("sessionBean", sessionBean.getId());
        model.addAttribute("singletonBean", singletonBean.getId());
        model.addAttribute("defaultBean", defaultBean.getId());
        return "scopes";
    }
}