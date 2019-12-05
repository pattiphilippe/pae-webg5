package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.demo.model.CourseTest.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest{
    
    @Autowired
    private CourseService courseService;

    @MockBean
    private CourseRepository courseRepository;

    @Test
    public void findAllAsList(){
        Course course1 = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        Course course2 = new Course("OTHER_ID", "OTHER_LIBELLE", DFT_ECTS, DFT_ETUDIANTS);
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        Mockito.when(courseRepository.findAll()).thenReturn(courses);
        List<Course> found = courseService.getAll();
        assertEquals(2, found.size());
        assertEquals(course1, found.get(0));
        assertEquals(course2, found.get(1));
    }
    
    @Test
    public void getCourseById(){
        Course course = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        Mockito.when(courseRepository.findById(DFT_ID)).thenReturn(Optional.of(course));
        Optional<Course> found = courseService.getCourseById(DFT_ID);
        assert(found.isPresent());
        assertEquals(found.get(), course);
    }

    @Test
    public void getCourseByLibelle(){
        Course course = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        Mockito.when(courseRepository.findByLibelle(DFT_LIBELLE)).thenReturn(Optional.of(course));
        Optional<Course> found = courseService.getCourseByLibelle(DFT_LIBELLE);
        assert(found.isPresent());
        assertEquals(found.get(), course);
    }
}