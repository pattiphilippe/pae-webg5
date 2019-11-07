package com.example.demo.business;

import com.example.demo.model.Etudiant;

import org.springframework.data.repository.CrudRepository;

public interface EtudiantDB extends CrudRepository<Etudiant, Integer> {
    
}