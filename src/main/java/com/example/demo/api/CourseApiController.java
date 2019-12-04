package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import com.example.demo.database.CourseDB;
import com.example.demo.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseApiController{

    @Autowired
    private CourseDB courseDB;

    @RequestMapping(path = "/api/getCourses")
    public List<Course> getCourses(){
        return courseDB.getAllCourses();
    }

    @RequestMapping(path ="/api/getCourses/{id}")
    public Course getCourse(@PathVariable("id") String id){
        Optional<Course> course = courseDB.findById(id);
        if(course.isEmpty()){
            throw new IllegalArgumentException("Pas de cours avec cet id!");
        }
        return course.get();
    }
}