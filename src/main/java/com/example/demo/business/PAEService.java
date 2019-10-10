package com.example.demo.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.model.Course;

import org.springframework.stereotype.Service;

@Service
public class PAEService{

    private List<Course> courses;

    public PAEService(){
        courses = new ArrayList<Course>(Arrays.asList(
        new Course("INT1", "Introductions", 10),
        new Course("MAT1", "Mathématiques II", 3),
        new Course("CAI1", "Anglais I", 2),
        new Course("DEV1", "Développement I", 10),
        new Course("DEV2", "Développement II", 10),
        new Course("WEBG2", "Développement web I", 2)
        ));
    }

    public List<Course> getCourses(){
        return courses;
    }

	public void addCourse(Course newCourse) {
        courses.add(newCourse);
	}
}