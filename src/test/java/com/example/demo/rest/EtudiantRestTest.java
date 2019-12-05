package com.example.demo.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Etudiant;
import com.example.demo.service.EtudiantService;

import static com.example.demo.model.EtudiantTest.*;

@RunWith(SpringRunner.class)
@WebMvcTest(EtudiantRest.class)
public class EtudiantRestTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EtudiantService etudiantService;

    @Test
    public void getEtudiants() throws Exception {
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        Etudiant etudiant2 = new Etudiant(43198, "Paul", DFT_COURSES);
        List<Etudiant> etudiants = new ArrayList<Etudiant>();
        etudiants.add(etudiant);
        etudiants.add(etudiant2);
        Mockito.when(etudiantService.getAll()).thenReturn(etudiants);
        mvc.perform(get("/api/getEtudiants/"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.[:1].matricule").value(etudiant.getMatricule()))
            .andExpect(jsonPath("$.[1:2].matricule").value(etudiant2.getMatricule()));
    }

    @Test
    public void getEtudiantByMatricule() throws Exception {
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        Mockito.when(etudiantService.getEtudiantByMatricule(DFT_MATRICULE)).thenReturn(Optional.of(etudiant));
        mvc.perform(get("/api/getEtudiants/"+DFT_MATRICULE))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.matricule").value(etudiant.getMatricule()));
    }

    @Test
    public void getEtudiantByName() throws Exception {
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        Mockito.when(etudiantService.getEtudiantByName(DFT_NAME)).thenReturn(Optional.of(etudiant));
        mvc.perform(get("/api/getEtudiants/"+DFT_NAME))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.matricule").value(etudiant.getMatricule()));
    }

}