package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.CourseRepository;
import com.example.demo.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.model.Course.*;

@RestController
public class CourseApiController{

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(path = "/api/getCourses")
    public List<Course> getCourses(){
        return courseRepository.findAllAsList();
    }

    @RequestMapping(path = "/api/getCourses/{id:" + REGEX_ID + "}")
    public Course getCourseById(@PathVariable("id") String id){
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()){
            throw new IllegalArgumentException("Pas de cours avec cet id!");
        }
        return course.get();
    }

    @RequestMapping("/api/getCourses/{libelle:" + REGEX_LIBELLE + "}")
    public Course getCourseByLibelle(@PathVariable("libelle") String libelle){
        Optional<Course> course = courseRepository.findByLibelle(libelle);
        if(course.isEmpty()){
            throw new IllegalArgumentException("Pas de cours avec ce libelle!");
        }
        return course.get();
    }
}