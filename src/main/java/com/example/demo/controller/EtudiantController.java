package com.example.demo.controller;

import java.util.List;

import com.example.demo.database.EtudiantDB;
import com.example.demo.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


@Controller
public class EtudiantController{

    @Autowired
    private EtudiantDB etudiantDB;

    @GetMapping("/etudiants")
    public String etudiants(Model model) {
        model.addAttribute("etudiants", etudiantDB.findAll());
        return "etudiants";
    }

    @GetMapping("/etudiants/json")
    public List<Etudiant> getEtudiantsJson(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/api/getPae", List.class);
    }
    
    
}