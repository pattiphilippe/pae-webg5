package com.example.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course{
    @Id
    @NotBlank(message="Message d'erreur modifié - not blank error")
    private String id;
    @NotBlank
    @Column(unique = true)
    private String libelle;
    @Min(1)
    @Max(30)
    private int ects;

    @ManyToMany
    @JoinTable(
      name = "inscriptions", 
      joinColumns = @JoinColumn(name = "course_id"), 
      inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonManagedReference
    private Collection<Etudiant> etudiants;

}