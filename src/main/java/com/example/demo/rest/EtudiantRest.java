package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import com.example.demo.service.EtudiantService;
import com.example.demo.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantRest{

    @Autowired 
    private EtudiantService etudiantService;
    
    @RequestMapping(path="/api/getEtudiants")
    public List<Etudiant> getEtudiants(){
        return etudiantService.getAll();
    }

    @RequestMapping(path ="/api/getEtudiants/{matricule:\\d+}")
    public Etudiant getEtudiant(@PathVariable("matricule") int matricule){
        Optional<Etudiant> etudiant = etudiantService.getEtudiantByMatricule(matricule);
        if(etudiant.isEmpty()){
            throw new IllegalArgumentException("Pas d'etudiant avec ce matricule!");
        }
        return etudiant.get();
    }

    @RequestMapping(path ="/api/getEtudiants/{name:[a-zA-Z]+}")
    public Etudiant getEtudiant(@PathVariable("name") String name){
        Optional<Etudiant> etudiant = etudiantService.getEtudiantByName(name);
        if(etudiant.isEmpty()){
            throw new IllegalArgumentException("Pas d'etudiant avec ce nom!");
        }
        return etudiant.get();
    }
}