package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.EtudiantRepository;
import com.example.demo.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantApiController{

    @Autowired 
    private EtudiantRepository etudiantRepository;
    
    @RequestMapping(path="/api/getEtudiants")
    public List<Etudiant> getEtudiants(){
        return etudiantRepository.findAllAsList();
    }

    @RequestMapping(path ="/api/getEtudiants/{matricule}")
    public Etudiant getEtudiant(@PathVariable("matricule") int matricule){
        Optional<Etudiant> etudiant = etudiantRepository.findById(matricule);
        if(etudiant.isEmpty()){
            throw new IllegalArgumentException("Pas d'etudiant avec ce matricule!");
        }
        return etudiant.get();
    }
}