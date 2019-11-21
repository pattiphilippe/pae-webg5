package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import com.example.demo.database.EtudiantDB;
import com.example.demo.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantApiController{

    @Autowired 
    private EtudiantDB etudiantDb;
    
    @RequestMapping(path="/api/getEtudiants")
    public List<Etudiant> getEtudiants(){
        return etudiantDb.getAllEtudiants();
    }

    @RequestMapping(path ="/api/getEtudiant/{matricule}")
    public Etudiant getEtudiant(@PathVariable("matricule") int matricule){
        Optional<Etudiant> etudiant = etudiantDb.findById(matricule);
        if(etudiant.isEmpty()){
            throw new IllegalArgumentException("Pas d'etudiant avec ce matricule!");
        }
        return etudiant.get();
    }
}