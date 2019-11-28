package com.example.demo.apprentissage.oto.biderectionnal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
class D { 
    @Id
    private int d_id;

    @OneToOne(mappedBy = "d")
    private C c_id;
}