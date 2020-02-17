package patti.philippe.recap.repository;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;

import patti.philippe.recap.model.Section;
import patti.philippe.recap.model.Student;
import patti.philippe.recap.model.StudentFilter;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    default Collection<Student> filter(@NotNull StudentFilter filter) {

        Section filterSection = filter.getSection() == null || filter.getSection().isEmpty() ?
            null : Section.valueOf(filter.getSection());
        return StreamSupport.stream(findAll().spliterator(), false)
            .filter(filter.getNumber() == null ? s -> true : s -> String.valueOf(s.getNumber()).contains(filter.getNumber()))
            .filter(filter.getName() == null ? s -> true : s -> s.getName().contains(filter.getName()))
            .filter(filterSection == null ? s -> true : s -> s.getSection().equals(filterSection))
            .filter(filter.getBloc() == null ? s -> true : s -> s.getBloc() == filter.getBloc())
            .collect(Collectors.toList());
    } 
    
}