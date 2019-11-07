package com.example.demo.business;

import com.example.demo.model.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseDB extends CrudRepository<Course, String> {
    
}