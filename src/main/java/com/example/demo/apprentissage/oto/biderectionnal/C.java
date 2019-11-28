package com.example.demo.apprentissage.oto.biderectionnal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class C { 
    @Id
    private int c_id;

    @OneToOne
    @JoinColumn(name = "d_id")
    private D d;
}