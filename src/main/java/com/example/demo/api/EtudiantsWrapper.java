package com.example.demo.api;

import java.util.List;

import com.example.demo.model.Etudiant;

import lombok.Data;

@Data
public class EtudiantsWrapper{
    private List<Etudiant> etudiants;
}