package com.example.demo.business;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseDB extends CrudRepository<Course, String> {

    default List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        findAll().forEach(courses::add);
        return courses;
    }
}