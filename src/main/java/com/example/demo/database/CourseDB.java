package com.example.demo.database;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseDB extends CrudRepository<Course, String> {

    default List<Course> findAllAsList(){
        List<Course> courses = new ArrayList<>();
        findAll().forEach(courses::add);
        return courses;
    }

    public Course findByLibelle(String libelle);
}