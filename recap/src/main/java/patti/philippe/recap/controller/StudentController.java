package patti.philippe.recap.controller;

import patti.philippe.recap.model.Section;
import patti.philippe.recap.model.Student;
import patti.philippe.recap.model.StudentFilter;
import patti.philippe.recap.repository.*;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController{

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RegistrationRepository registrationRepository;

    private final int [] blocs = {1,2,3};


    private void initStudentsModelParams(Model model, Principal principal){
        model.addAttribute("sections", Section.values());
        model.addAttribute("blocs", blocs);
        model.addAttribute("username", principal.getName());
    }

    @GetMapping("/students")
    public String students(Model model, Principal principal) {
        initStudentsModelParams(model, principal);
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("filter", new StudentFilter());
        return "students/students";
    }


    @PostMapping("/students")
    public String filter(@ModelAttribute("filter") StudentFilter filter, Model model, Principal principal){
        initStudentsModelParams(model, principal);
        model.addAttribute("students", studentRepository.filter(filter));
        return "students/students";
    }

    
    @GetMapping("/students/{number}")
    @PreAuthorize("hasRole('ROLE_TEACHER') or isOwner(#number, #principal)")
    public String detailStudent(@PathVariable("number") int number, Model model, Principal principal){
        Optional<Student> student = studentRepository.findById(number);
        if(student.isEmpty()){
            throw new IllegalArgumentException("No student with this number!");
        }

        model.addAttribute("username", principal.getName());
        model.addAttribute("student", student.get());
        model.addAttribute("registrations", registrationRepository.findByAnnualProgram(number));
        return "students/detail_student";
    }
    
}