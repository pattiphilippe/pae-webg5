package com.example.demo.api;

import java.util.List;

import com.example.demo.model.Course;

import lombok.Data;

@Data
public class CoursesWrapper{
    private List<Course> courses;
}