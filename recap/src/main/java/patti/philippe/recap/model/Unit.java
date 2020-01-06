package patti.philippe.recap.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unit {

    @Id
    private String id;
    @NotBlank
    @NotNull
    private String title;
    @Min(1)
    @Max(6)
    private int semester;
    @Min(1)
    private int ects;

    @ElementCollection
    @CollectionTable(name = "Unit_Sections", 
        joinColumns = @JoinColumn(name="unit_id"))
    @Column(name = "sections", length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private Collection<Section> unit_sections;

    @OneToMany(mappedBy = "unit_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Registration> registrations;
}