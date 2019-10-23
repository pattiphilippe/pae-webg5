package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.business.PAEService;
import com.example.demo.model.Course;
import com.example.demo.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

@Controller
@SessionAttributes("courses")
public class CourseController{

    @Autowired 
    private PAEService pae;

    @ModelAttribute(name = "courses")
    public List<Course> coursesAttr(Model model){
        return pae.getCourses();
    }

    @ModelAttribute(name = "etudiants")
    public List<Etudiant> etudiantsAttr(Model model){
        return pae.getEtudiants();
    }

    @GetMapping("/courses")
    public String courses(Model model){
        model.addAttribute("newCourse", new Course());
        return "courses";
    }

    @PostMapping("/urlCtrl")
    public String doSomething( @Valid Course newCourse, Errors errors){
        if(errors.hasErrors()){
            return "redirect:/courses";
        }
        pae.addCourse(newCourse);
        return "redirect:/courses";
    }

    @GetMapping("/courses/json")
    public List<Course> getCoursesJson(){
        System.out.println("JLC ------ DEBUT APPEL SERVICE");
        RestTemplate restTemplate = new RestTemplate();
        PAEService pae = restTemplate.getForObject("http://localhost:8080/api/getPae", PAEService.class);
        System.out.println("JLC ------ FIN APPEL SERVICE");
        return pae.getCourses();
    }
}