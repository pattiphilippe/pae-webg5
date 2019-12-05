package com.example.demo.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @Min(40000)
    @Max(59999)
    private int matricule;
    @NotBlank
    private String name;

    @ManyToMany(mappedBy="etudiants", fetch = FetchType.LAZY)
    @JsonBackReference
    private Collection<Course> courses;
}
