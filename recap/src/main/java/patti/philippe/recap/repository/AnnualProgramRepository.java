package patti.philippe.recap.repository;

import org.springframework.data.repository.CrudRepository;

import patti.philippe.recap.model.AnnualProgram;

public interface AnnualProgramRepository extends CrudRepository<AnnualProgram, Integer> {
    
}