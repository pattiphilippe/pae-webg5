package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.database.EtudiantDB;
import com.example.demo.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class EtudiantController{

    @Autowired
    private EtudiantDB etudiantDB;

    @GetMapping("/etudiants")
    public String etudiants(Model model) {
        model.addAttribute("etudiants", etudiantDB.findAll());
        return "etudiants/etudiants";
    }
    
    @GetMapping("/etudiants/{id}")
    public String detailEtudiant(@PathVariable("id") int id, Model model){
        Optional<Etudiant> etudiant = etudiantDB.findById(id);
        if(etudiant.isEmpty()){
            throw new IllegalArgumentException("Pas d'étudiant avec ce matricule!");
        }
        model.addAttribute("detail", etudiant.get());
        return "etudiants/detail_etudiant";
    }
    
}