package com.example.demo;

import com.example.demo.database.CourseDB;
import com.example.demo.database.EtudiantDB;
import com.example.demo.model.Course;
import com.example.demo.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class TestDB implements CommandLineRunner {

    @Autowired
    private CourseDB courseDB;
    
    @Autowired
    private EtudiantDB etudiantDB;

    @Override
    public void run (String... args){
        log.info(courseDB.findAll().toString());
        courseDB.save(new Course("INT2", "INTRO 2", 4));
        log.info(courseDB.findAll().toString());
        log.info(etudiantDB.findAll().toString());
        etudiantDB.save(new Etudiant(42222, "Oui"));
        log.info(etudiantDB.findAll().toString());
    }
}