package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import com.example.demo.service.CourseService;
import com.example.demo.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.model.Course.*;

@RestController
public class CourseRest{

    @Autowired
    private CourseService courseService;

    @RequestMapping(path = "/api/getCourses")
    public List<Course> getCourses(){
        return courseService.getAll();
    }

    @RequestMapping(path = "/api/getCourses/{id:" + REGEX_ID + "}")
    public Course getCourseById(@PathVariable("id") String id){
        Optional<Course> course = courseService.getCourseById(id);
        if(course.isEmpty()){
            throw new IllegalArgumentException("Pas de cours avec cet id!");
        }
        return course.get();
    }

    @RequestMapping("/api/getCourses/{libelle:" + REGEX_LIBELLE + "}")
    public Course getCourseByLibelle(@PathVariable("libelle") String libelle){
        Optional<Course> course = courseService.getCourseByLibelle(libelle);
        if(course.isEmpty()){
            throw new IllegalArgumentException("Pas de cours avec ce libelle!");
        }
        return course.get();
    }
}