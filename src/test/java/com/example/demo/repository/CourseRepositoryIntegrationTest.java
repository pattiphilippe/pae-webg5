package com.example.demo.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.demo.model.CourseTest.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryIntegrationTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findByLibelle(){
        Course course = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        courseRepository.save(course);
        Optional<Course> found = courseRepository.findByLibelle(course.getLibelle());
        assert(found.isPresent());
        assertEquals(course, found.get());
    }

    @Test
    public void findAllAsList(){
        Course course1 = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        Course course2 = new Course("OTHER_ID", "OTHER_LIBELLE", DFT_ECTS, DFT_ETUDIANTS);
        courseRepository.save(course1);
        courseRepository.save(course2);
        List<Course> found = courseRepository.findAllAsList();
        assertEquals(2, found.size());
        assertEquals(course1, found.get(0));
        assertEquals(course2, found.get(1));
    }
}