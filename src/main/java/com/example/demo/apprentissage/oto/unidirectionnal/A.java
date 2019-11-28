package com.example.demo.apprentissage.oto.unidirectionnal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class A { 
    @Id
    private int a_id;

    @OneToOne
    @JoinColumn(name = "b_id")
    private B b;
}