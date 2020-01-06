package patti.philippe.recap.repository;

import org.springframework.data.repository.CrudRepository;

import patti.philippe.recap.model.Unit;

public interface UnitRepository extends CrudRepository<Unit, String> {
    
}