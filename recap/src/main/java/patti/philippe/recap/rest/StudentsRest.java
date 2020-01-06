package patti.philippe.recap.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import patti.philippe.recap.model.Student;
import patti.philippe.recap.repository.StudentRepository;

@RestController
public class StudentsRest {

    @Autowired
    private StudentRepository studentRepository;
    
    @RequestMapping(path = "/students/json")
    public Collection<Student> getStudents(){
        Collection<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    
    @RequestMapping(path = "/students/{id}/json")
    public Student getStudents(@PathVariable("id") int id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new IllegalArgumentException("Pas d'etudiant avec ce nom!");
        }
        return student.get();
    }
}