package com.example.demo.database;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.demo.model.Course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.demo.model.CourseTest.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseDBIntegrationTest {

    @Autowired
    private CourseDB courseDB;

    @Test
    public void findByLibelle(){
        Course course = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        courseDB.save(course);
        Course found = courseDB.findByLibelle(course.getLibelle());
        assertEquals(course, found);
    }

    @Test
    public void findAllAsList(){
        Course course1 = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        Course course2 = new Course("OTHER_ID", "OTHER_LIBELLE", DFT_ECTS, DFT_ETUDIANTS);
        courseDB.save(course1);
        courseDB.save(course2);
        List<Course> found = courseDB.findAllAsList();
        assertEquals(2, found.size());
        assertEquals(course1, found.get(0));
        assertEquals(course2, found.get(1));
    }
}