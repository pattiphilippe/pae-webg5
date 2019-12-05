package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

    default List<Course> findAllAsList(){
        List<Course> courses = new ArrayList<>();
        findAll().forEach(courses::add);
        return courses;
    }

    public Optional<Course> findByLibelle(String libelle);
}