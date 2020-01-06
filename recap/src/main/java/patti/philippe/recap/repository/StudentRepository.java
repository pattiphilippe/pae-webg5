package patti.philippe.recap.repository;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.repository.CrudRepository;

import patti.philippe.recap.model.Section;
import patti.philippe.recap.model.Student;
import patti.philippe.recap.model.StudentFilter;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    default Collection<Student> filter(StudentFilter filter) {
        return StreamSupport.stream(findAll().spliterator(), false)
            .filter(student -> {
                if(filter.getName() != null){
                    if(!student.getName().contains(filter.getName())){
                        return false;
                    }
                }
                if(filter.getPartialName() != null){
                    if(!student.getName().contains(filter.getPartialName())){
                        return false;
                    }
                }
                if(filter.getSection() != null && !filter.getSection().isEmpty()){
                    if(!student.getSection().equals(Section.valueOf(filter.getSection()))){
                        return false;
                    }
                }
                if(filter.getBloc() != null){
                    if(student.getBloc() != filter.getBloc()){
                        return false;
                    }
                }
                return true;
            }).collect(Collectors.toList());
    }
    
}