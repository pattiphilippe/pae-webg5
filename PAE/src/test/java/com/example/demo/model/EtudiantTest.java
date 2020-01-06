package com.example.demo.model;


import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EtudiantTest {

    @Autowired
    private BeanValidationUtil<Etudiant> validator;

    public static final int DFT_MATRICULE = 43197; 
    public static final String DFT_NAME = "NAME";
    public static final List<Course> DFT_COURSES = null; 


    @Test
    public void matriculeValid(){
        int [] limitValues = {40000, DFT_MATRICULE, 59999};
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        for(int limitValue : limitValues){
            etudiant.setMatricule(limitValue);
            validator.assertIsValid(etudiant);
        }
    }

    @Test
    public void matriculeMinErrors(){
        int [] limitValues = {39999, 0, -1};
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        for(int limitValue : limitValues){
            etudiant.setMatricule(limitValue);
            validator.assertHasError(etudiant, "matricule", Min.class);
        }
    }

    @Test
    public void matriculeMaxErrors(){
        int [] limitValues = {60000, 1_000_000_000};
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        for(int limitValue : limitValues){
            etudiant.setMatricule(limitValue);
            validator.assertHasError(etudiant, "matricule", Max.class);
        }
    }


    @Test
    public void nameValid(){
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, DFT_NAME, DFT_COURSES);
        validator.assertIsValid(etudiant);
    }

    @Test
    public void nameBlankError(){
        Etudiant etudiant = new Etudiant(DFT_MATRICULE, "", DFT_COURSES);
        validator.assertHasError(etudiant, "name", NotBlank.class);
    }



    //TODO test many to many relation
}