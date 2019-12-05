package com.example.demo.database;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.demo.model.Etudiant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.demo.model.EtudiantTest.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EtudiantDBIntegrationTest {

    @Autowired
    private EtudiantDB etudiantDB;

    @Test
    public void findByName(){
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        etudiantDB.save(etudiant);
        Etudiant found = etudiantDB.findByName(etudiant.getName());
        assertEquals(etudiant, found);
    }

    @Test
    public void findAllAsList(){
        Etudiant etudiant1 = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        Etudiant etudiant2 = new Etudiant(43198, "OTHER_NAME", DFT_COURSES);
        etudiantDB.save(etudiant1);
        etudiantDB.save(etudiant2);
        List<Etudiant> found = etudiantDB.findAllAsList();
        assertEquals(2, found.size());
        assertEquals(etudiant1, found.get(0));
        assertEquals(etudiant2, found.get(1));
    }
}