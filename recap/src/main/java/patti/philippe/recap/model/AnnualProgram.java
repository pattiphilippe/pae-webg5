package patti.philippe.recap.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnualProgram {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id; 

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_number", nullable = false)
    private Student student_number;

    @OneToMany(mappedBy = "annual_program_id", cascade = CascadeType.ALL)
    private Collection<Registration> registrations;
    
}