package com.example.demo.model;

import lombok.Value;

@Value
public class Course{
    private String id;
    private String libelle;
    private int ects;
}