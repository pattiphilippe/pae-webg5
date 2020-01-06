package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.model.Etudiant;

import org.springframework.data.repository.CrudRepository;

public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {

    public Optional<Etudiant> findByName(String name);
    
}