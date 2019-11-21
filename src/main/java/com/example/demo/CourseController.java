package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.business.CourseDB;
import com.example.demo.business.EtudiantDB;
import com.example.demo.business.PAEService;
import com.example.demo.model.Course;
import com.example.demo.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

@Controller
@SessionAttributes("courses")
public class CourseController{

    @Autowired
    private CourseDB courseDB;
    
    @Autowired
    private EtudiantDB etudiantDB;

    @GetMapping("/courses")
    public String courses(Model model){
        model.addAttribute("newCourse", new Course());
        model.addAttribute("courses", courseDB.findAll());
        model.addAttribute("etudiants", etudiantDB.findAll());
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

    @GetMapping("/courses/json")
    public List<Course> getCoursesJson(){
        RestTemplate restTemplate = new RestTemplate();
        PAEService pae = restTemplate.getForObject("http://localhost:8080/api/getPae", PAEService.class);
        return pae.getCourses();
    }

    @GetMapping("/etudiants/json")
    public List<Etudiant> getEtudiantsJson(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/api/getPae", List.class);
    }
}