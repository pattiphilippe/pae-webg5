package com.example.demo.controller;

import com.example.demo.database.EtudiantDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EtudiantController{

    @Autowired
    private EtudiantDB etudiantDB;

    @GetMapping("/etudiants")
    public String etudiants(Model model) {
        model.addAttribute("etudiants", etudiantDB.findAll());
        return "etudiants";
    }
    
    
}