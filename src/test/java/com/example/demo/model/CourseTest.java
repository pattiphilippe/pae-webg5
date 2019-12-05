package com.example.demo.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTest {

    @Autowired
    private BeanValidationUtil<Course> validator;

    public static final String DFT_ID = "MOBG5"; 
    public static final String DFT_LIBELLE = "Développement Mobile"; 
    public static final int DFT_ECTS = 5; 
    public static final List<Etudiant> DFT_ETUDIANTS = null; 


    @Test
    public void idValid(){
        Course course = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        validator.assertIsValid(course);
    }

    @Test
    public void idBlankError(){
        Course course = new Course("", DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        validator.assertHasError(course, "id", Pattern.class);
        course = new Course(" ", DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        validator.assertHasError(course, "id", Pattern.class);
    }

    //TODO test regex

    @Test
    public void libelleValid(){
        Course course = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        validator.assertIsValid(course);
    }

    @Test
    public void libelleBlankError(){
        Course course = new Course(DFT_ID, "", DFT_ECTS, DFT_ETUDIANTS);
        validator.assertHasError(course, "libelle", Pattern.class);
        course = new Course(DFT_ID, " ", DFT_ECTS, DFT_ETUDIANTS);
        validator.assertHasError(course, "libelle", Pattern.class);
    }

    //TODO test libelle unique

    @Test
    public void ectsValid(){
        int [] limitValues = {1, 5, 30};
        Course course = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        for(int limitValue : limitValues){
            course.setEcts(limitValue);
            validator.assertIsValid(course);
        }
    }

    @Test
    public void ectsMinErrors(){
        int [] limitValues = {0, -1};
        Course course = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        for(int limitValue : limitValues){
            course.setEcts(limitValue);
            validator.assertHasError(course, "ects", Min.class);
        }
    }

    @Test
    public void ectsMaxErrors(){
        int [] limitValues = {31, 1_000_000_000};
        Course course = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        for(int limitValue : limitValues){
            course.setEcts(limitValue);
            validator.assertHasError(course, "ects", Max.class);
        }
    }

    //TODO test many to many relation

}