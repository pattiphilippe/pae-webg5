package com.example.demo.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

import static com.example.demo.model.CourseTest.*;

@RunWith(SpringRunner.class)
//@WebMvcTest(CourseRest.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CourseRestTest {


    //TODO bonne piste pour test avec sécurité
    //https://www.baeldung.com/spring-security-integration-tests
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(springSecurity())
            .build();
    }

    @MockBean
    private CourseService courseService;

    @WithMockUser(username = "user", password = "user", roles = "STUDENT")
    @Test
    public void getCourses() throws Exception {
        Course course1 = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        Course course2 = new Course("PRJG5", "Gestion de Projet", 5, DFT_ETUDIANTS);
        List<Course> courses = new ArrayList<Course>();
        courses.add(course1);
        courses.add(course2);
        Mockito.when(courseService.getAll()).thenReturn(courses);
        mvc.perform(get("/api/getCourses/"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.[:1].id").value(course1.getId()))
            .andExpect(jsonPath("$.[1:2].id").value(course2.getId()));
    }

    @Test
    public void getCourseById() throws Exception {
        Course course = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        Mockito.when(courseService.getCourseById(DFT_ID)).thenReturn(Optional.of(course));
        mvc.perform(get("/api/getCourses/" + DFT_ID))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(DFT_ID));
    }

    @Test
    public void getCourseByLibelle() throws Exception {
        String libelle = "Developpement Mobile";
        Course course = new Course(DFT_ID, libelle, DFT_ECTS, DFT_ETUDIANTS);
        Mockito.when(courseService.getCourseByLibelle(libelle)).thenReturn(Optional.of(course));
        mvc.perform(get("/api/getCourses/"+libelle))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.libelle").value(libelle));
    }

    @Test
    public void getCourseByLibelleWithSpecialCharacters() throws Exception {
        String libelle = "Développement Mobile";
        String specialLibelle = "D%C3%A9veloppement%20Mobile";
        Course course = new Course(DFT_ID, libelle, DFT_ECTS, DFT_ETUDIANTS);
        Mockito.when(courseService.getCourseByLibelle(specialLibelle)).thenReturn(Optional.of(course));
        mvc.perform(get("/api/getCourses/"+ specialLibelle))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.libelle").value(libelle));
    }

}