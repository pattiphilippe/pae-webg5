package com.example.demo.controller;

import javax.validation.Valid;

import com.example.demo.database.CourseDB;
import com.example.demo.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController{

    @Autowired
    private CourseDB courseDB;
    

    @GetMapping("/courses")
    public String courses(Model model){
        model.addAttribute("courses", courseDB.findAll());
        model.addAttribute("newCourse", new Course());
        return "courses";
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
}