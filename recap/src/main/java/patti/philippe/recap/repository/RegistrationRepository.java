package patti.philippe.recap.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import patti.philippe.recap.model.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
    
    default Collection<Registration> findByAnnualProgram(int studentNumber){
        Collection<Registration> registrations = new ArrayList<>(0);
        for(Registration registration : findAll()){
            if(registration.getAnnual_program_id().getStudent_number().getNumber() == studentNumber){
                registrations.add(registration);
            }
        }
        return registrations;
    }
}