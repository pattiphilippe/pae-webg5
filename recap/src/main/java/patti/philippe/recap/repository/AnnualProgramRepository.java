package patti.philippe.recap.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import patti.philippe.recap.model.AnnualProgram;

public interface AnnualProgramRepository extends CrudRepository<AnnualProgram, Integer> {

    default Optional<AnnualProgram> findByStudentNumber(int number){
        Optional<AnnualProgram> optional = Optional.empty();
        for(AnnualProgram annualProgram : findAll()){
            if(annualProgram.getStudent_number().getNumber() == number){
                return Optional.of(annualProgram);
            }
        }
        return optional;
    }

}