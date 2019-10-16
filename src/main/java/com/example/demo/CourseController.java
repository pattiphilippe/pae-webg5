package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.business.PAEService;
import com.example.demo.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("courses")
public class CourseController{

    @Autowired 
    private PAEService pae;

    @ModelAttribute(name = "courses")
    public List<Course> test(Model model){
        return pae.getCourses();
    }

    @GetMapping("/courses")
    public String courses(Model model){
        model.addAttribute("newCourse", new Course());
        return "courses";
    }

    @PostMapping("/urlCtrl")
    public String doSomething(Model model, @Valid Course newCourse, BindingResult errors){
        if(errors.hasErrors()){
            model.addAttribute("errors", errors);
            return "redirect:/courses";
        }
        pae.addCourse(newCourse);
        return "redirect:/courses";
    }
}