package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.model.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

    public Optional<Course> findByLibelle(String libelle);
}