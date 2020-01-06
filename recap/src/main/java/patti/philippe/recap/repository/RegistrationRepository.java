package patti.philippe.recap.repository;

import org.springframework.data.repository.CrudRepository;

import patti.philippe.recap.model.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
    
}