package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Etudiant;
import com.example.demo.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Optional<Etudiant> getEtudiantByMatricule(int matricule){
        return etudiantRepository.findById(matricule);
    }

    public Optional<Etudiant> getEtudiantByName(String name){
        return etudiantRepository.findByName(name);
    }

    public List<Etudiant> getAll(){
        List<Etudiant> Etudiants = new ArrayList<>();
        etudiantRepository.findAll().forEach(Etudiants::add);
        return Etudiants;
    }
}