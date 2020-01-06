package patti.philippe.recap.controller;

import patti.philippe.recap.model.Section;
import patti.philippe.recap.model.Student;
import patti.philippe.recap.model.StudentFilter;
import patti.philippe.recap.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController{

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public String etudiants(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("sections", Section.values());
        int[] blocs = {1,2,3,4,5,6};
        model.addAttribute("blocs", blocs);
        model.addAttribute("filter", new StudentFilter());
        return "students/students";
    }


    @PostMapping("/students/filter")
    public String filter(@ModelAttribute("filter") StudentFilter filter, Model model){
        model.addAttribute("students", studentRepository.filter(filter));
        return "students/students";
    }
    
}