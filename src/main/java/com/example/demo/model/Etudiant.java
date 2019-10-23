package com.example.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Value;

@Value
public class Etudiant {
    @Min(40000)
    @Max(59999)
    private int matricule;
    @NotBlank
    private String name;
}
