package com.example.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course{
    @NotBlank(message="Message d'erreur modifié - not blank error")
    private String id;
    @NotBlank
    private String libelle;
    @Min(1)
    private int ects;

}