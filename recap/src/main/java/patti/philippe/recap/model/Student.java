package patti.philippe.recap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @GeneratedValue(generator = "student_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="student_seq", sequenceName = "student_seq",
    allocationSize = 1)
    @Id
    private int number;
    private String name;
    @Min(1)
    @Max(3)
    private int bloc;

    @Enumerated(EnumType.STRING)
    @Column(length = 1, nullable = false)
    private Section section;

}