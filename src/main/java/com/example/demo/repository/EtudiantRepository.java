package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Etudiant;

import org.springframework.data.repository.CrudRepository;

public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {

    default List<Etudiant> findAllAsList(){
        List<Etudiant> etudiants = new ArrayList<>();
        findAll().forEach(etudiants::add);
        return etudiants;
    }

    public Etudiant findByName(String name);
    
}