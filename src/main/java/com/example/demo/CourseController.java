package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.business.PAE;
import com.example.demo.business.PAEService;
import com.example.demo.model.Course;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("courses")
public class CourseController{

    /*
    @GetMapping("/courses")
    public String courses(Model model){
        model.addAttribute("courses", PAE.getCourses());
        model.addAttribute("newCourse", new Course());
        return "courses";
    }
*/

    @ModelAttribute(name = "courses")
    public List<Course> test(Model model, PAEService pae){
        return pae.getCourses();
    }

    @GetMapping("/courses")
    public String courses(Model model){
        //model.addAttribute("courses", pae.getCourses());
        model.addAttribute("newCourse", new Course());
        return "courses";
    }

    /*
    @PostMapping("/urlCtrl")
    public String doSomething(Course newCourse){
        PAE.addCourse(newCourse);
        return "newCourse";
    }*/

    @PostMapping("/urlCtrl")
    public String doSomething(Model model, @Valid Course newCourse, PAEService pae, BindingResult errors){
        if(errors.hasErrors()){
            return "redirect:/courses";
        }
        pae.addCourse(newCourse);
        return "redirect:/courses";
    }
}