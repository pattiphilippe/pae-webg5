package com.example.demo.rest;

import java.util.List;

import com.example.demo.model.Course;

import lombok.Data;

@Data
public class CoursesWrapper{
    private List<Course> courses;
}