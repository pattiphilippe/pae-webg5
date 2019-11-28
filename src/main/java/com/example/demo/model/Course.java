package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course{
    @Id
    @NotBlank(message="Message d'erreur modifié - not blank error")
    private String id;
    @NotBlank
    private String libelle;
    @Min(1)
    private int ects;

}