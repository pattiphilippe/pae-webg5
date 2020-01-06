package patti.philippe.recap.controller;

import patti.philippe.recap.model.AnnualProgram;
import patti.philippe.recap.model.Registration;
import patti.philippe.recap.model.Section;
import patti.philippe.recap.model.Student;
import patti.philippe.recap.model.StudentFilter;
import patti.philippe.recap.model.Unit;
import patti.philippe.recap.repository.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
    private AnnualProgramRepository annualProgramRepository;
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private UnitRepository unitRepository;


    @GetMapping("/students")
    public String etudiants(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("sections", Section.values());
        int[] blocs = {1,2,3,4,5,6};
        model.addAttribute("blocs", blocs);
        model.addAttribute("filter", new StudentFilter());
        return "students/students";
    }


    @PostMapping("/students")
    public String filter(@ModelAttribute("filter") StudentFilter filter, Model model){
        model.addAttribute("students", studentRepository.filter(filter));
        model.addAttribute("sections", Section.values());
        int[] blocs = {1,2,3,4,5,6};
        model.addAttribute("blocs", blocs);
        return "students/students";
    }
    @GetMapping("/students/{number}")
    public String detailStudent(@PathVariable("number") int number, Model model){
        Optional<Student> student = studentRepository.findById(number);
        if(student.isEmpty()){
            throw new IllegalArgumentException("No student with this number!");
        }

        model.addAttribute("student", student.get());
        model.addAttribute("registrations", registrationRepository.findByAnnualProgram(number));
        return "students/detail_student";
    }
    
}