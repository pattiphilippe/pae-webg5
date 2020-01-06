package com.example.demo.service;

import com.example.demo.model.Etudiant;
import com.example.demo.repository.EtudiantRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.demo.model.EtudiantTest.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EtudiantServiceTest{
    
    @Autowired
    private EtudiantService etudiantService;

    @MockBean
    private EtudiantRepository etudiantRepository;

    @Test
    public void findAllAsList(){
        Etudiant etudiant1 = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        Etudiant etudiant2 = new Etudiant(43198, "Paul", DFT_COURSES);
        List<Etudiant> Etudiants = new ArrayList<>();
        Etudiants.add(etudiant1);
        Etudiants.add(etudiant2);
        Mockito.when(etudiantRepository.findAll()).thenReturn(Etudiants);
        List<Etudiant> found = etudiantService.getAll();
        assertEquals(2, found.size());
        assertEquals(etudiant1, found.get(0));
        assertEquals(etudiant2, found.get(1));
    }
    
    @Test
    public void getEtudiantByMatricule(){
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        Mockito.when(etudiantRepository.findById(DFT_MATRICULE)).thenReturn(Optional.of(etudiant));
        Optional<Etudiant> found = etudiantService.getEtudiantByMatricule(DFT_MATRICULE);
        assert(found.isPresent());
        assertEquals(found.get(), etudiant);
    }
    
    @Test
    public void getEtudiantByName(){
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        Mockito.when(etudiantRepository.findByName(DFT_NAME)).thenReturn(Optional.of(etudiant));
        Optional<Etudiant> found = etudiantService.getEtudiantByName(DFT_NAME);
        assert(found.isPresent());
        assertEquals(found.get(), etudiant);
    }
}