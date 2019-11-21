package com.example.demo.api;

import java.util.List;

import com.example.demo.database.CourseDB;
import com.example.demo.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseApiController{

    @Autowired
    private CourseDB courseDB;

    // TODO remove links to get pae api

    @RequestMapping(path = "/api/getCourses")
    public List<Course> getCourses(){
        return courseDB.getAllCourses();
    }
}