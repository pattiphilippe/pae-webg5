package patti.philippe.recap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Authority {
    @Id
    @GeneratedValue(generator = "security_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="security_seq", sequenceName = "security_seq",
    allocationSize = 1)
    private long id;
    private String username;
    private String authority;

}