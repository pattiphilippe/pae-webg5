package com.example.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import com.example.demo.model.Etudiant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.demo.model.EtudiantTest.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EtudiantRepositoryIntegrationTest {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Test
    public void findByName(){
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        etudiantRepository.save(etudiant);
        Optional<Etudiant> found = etudiantRepository.findByName(etudiant.getName());
        assertTrue(found.isPresent());
        assertEquals(etudiant, found.get());
    }


    //TODO test find all in Service
    // @Test
    // public void findAllAsList(){
    //     Etudiant etudiant1 = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
    //     Etudiant etudiant2 = new Etudiant(43198, "OTHER_NAME", DFT_COURSES);
    //     etudiantRepository.save(etudiant1);
    //     etudiantRepository.save(etudiant2);
    //     List<Etudiant> found = etudiantRepository.findAllAsList();
    //     assertEquals(2, found.size());
    //     assertEquals(etudiant1, found.get(0));
    //     assertEquals(etudiant2, found.get(1));
    // }
}