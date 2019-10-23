package com.example.demo.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.model.Course;
import com.example.demo.model.Etudiant;

import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
@Getter
public class PAEService{

    private List<Course> courses;
    private List<Etudiant> etudiants;

    private PAEService(){
        System.out.println("JLC ----- > appel a PAEService construct DEBUT");
        courses = new ArrayList<Course>(Arrays.asList(
        new Course("INT1", "Introductions", 10),
        new Course("MAT1", "Mathématiques II", 3),
        new Course("CAI1", "Anglais I", 2),
        new Course("DEV1", "Développement I", 10),
        new Course("DEV2", "Développement II", 10),
        new Course("WEBG2", "Développement web I", 2)
        ));

        etudiants = new ArrayList<>(Arrays.asList(
            new Etudiant(43197, "Philippe"),
            new Etudiant(49737, "Antony"),
            new Etudiant(47993, "Logan")
        ));
        System.out.println("JLC ----- > appel a PAEService construct FIN " + courses.size());
        
    }

	public void addCourse(Course newCourse) {
        System.out.println("JLC ----- > appel a PAEService addCourse");
        courses.add(newCourse);
	}

	public Etudiant getEtudiant(int matricule) {
        for(Etudiant et : etudiants){
            if(et.getMatricule() == matricule){
                return et;
            }
        }
		return null;
	}
}