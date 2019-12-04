package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.database.CourseDB;
import com.example.demo.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("courses")
public class CourseController{

    @Autowired
    private CourseDB courseDB;
    

    @GetMapping("/courses")
    public String courses(Model model){
        model.addAttribute("newCourse", new Course());
        model.addAttribute("courses", courseDB.findAll());
        Course c = new Course();
        return "courses/courses";
    }

    @PostMapping("/addNewCourse")
    public String doSomething(Model model, @Valid Course newCourse, Errors errors){
        //TODO insert errors
        if(errors.hasErrors()){
            return "redirect:/courses";
        }
        courseDB.save(newCourse);
        model.addAttribute("courses", courseDB.findAll());
        return "redirect:/courses";
    }

    @GetMapping("/courses/{id}")
    public String detailCours(@PathVariable("id") String id, Model model){
        Optional<Course> course = courseDB.findById(id);
        if(course.isEmpty()){
            throw new IllegalArgumentException("Pas de cours avec cet id!");
        }
        model.addAttribute("detail", course.get());
        return "courses/detail_course";
    }

}