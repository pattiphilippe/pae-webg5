package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.repository.CourseRepository;
import com.example.demo.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import static com.example.demo.model.Course.*;

@Controller
@SessionAttributes("courses")
public class CourseController{

    @Autowired
    private CourseRepository courseRepository;
    

    @GetMapping("/courses")
    public String courses(Model model){
		Course c = new Course("", "De", 5, null);
		System.out.println(c);
        model.addAttribute("newCourse", new Course());
        model.addAttribute("courses", courseRepository.findAll());
        return "courses/courses";
    }

    @PostMapping("/addNewCourse")
    public String doSomething(Model model, @Valid Course newCourse, Errors errors){
        //TODO insert errors
        if(errors.hasErrors()){
            return "redirect:/";
        }
        courseRepository.save(newCourse);
        model.addAttribute("courses", courseRepository.findAll());
        return "redirect:/courses";
    }

    @GetMapping("/courses/{id:" + REGEX_ID + "}")
    public String detailCoursById(@PathVariable("id") String id, Model model){
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()){
            throw new IllegalArgumentException("Pas de cours avec cet id!");
        }
        model.addAttribute("detail", course.get());
        return "courses/detail_course";
    }

    @GetMapping("/courses/{libelle:" + REGEX_LIBELLE + "}")
    public String detailCoursByLibelle(@PathVariable("libelle") String libelle, Model model){
        Optional<Course> course = courseRepository.findByLibelle(libelle);
        if(course.isEmpty()){
            throw new IllegalArgumentException("Pas de cours avec ce libelle!");
        }
        model.addAttribute("detail", course.get());
        return "courses/detail_course";
    }
}