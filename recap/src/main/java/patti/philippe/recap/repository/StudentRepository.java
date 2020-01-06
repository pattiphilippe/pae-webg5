package patti.philippe.recap.repository;

import org.springframework.data.repository.CrudRepository;

import patti.philippe.recap.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    
}