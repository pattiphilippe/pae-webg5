package com.example.demo;

import java.util.List;

import com.example.demo.business.PAEService;
import com.example.demo.model.Course;
import com.example.demo.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseApiController{

    @Autowired
    private PAEService pae;

    @RequestMapping(path = "/api/getPae")
    public PAEService getPae(){
        return pae;
    }

    @RequestMapping(path = "/api/getCourses")
    public List<Course> getCourses(){
        return pae.getCourses();
    }

    @RequestMapping(path ="/api/getEtudiant/{matricule}")
    public Etudiant getEtudiant(@PathVariable("matricule") int matricule){
        return pae.getEtudiant(matricule);
    }
}