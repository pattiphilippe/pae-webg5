package com.example.demo.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.model.Course;

public class PAE{

    private static final List<Course> courses = new ArrayList<Course>(Arrays.asList(
        new Course("INT1", "Introductions", 10),
        new Course("MAT1", "Mathématiques II", 3),
        new Course("CAI1", "Anglais I", 2),
        new Course("DEV1", "Développement I", 10),
        new Course("DEV2", "Développement II", 10),
        new Course("WEBG2", "Développement web I", 2)
    ));

    public static List<Course> getCourses(){
        System.out.println("JLC ----- > appel a PAE");
        return new ArrayList<>(courses);
    }

    public static void addCourse(Course course){
        PAE.courses.add(course);
    }
}