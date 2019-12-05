package com.example.demo.database;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Etudiant;

import org.springframework.data.repository.CrudRepository;

public interface EtudiantDB extends CrudRepository<Etudiant, Integer> {

    default List<Etudiant> findAllAsList(){
        List<Etudiant> etudiants = new ArrayList<>();
        findAll().forEach(etudiants::add);
        return etudiants;
    }

    public Etudiant findByName(String name);
    
}