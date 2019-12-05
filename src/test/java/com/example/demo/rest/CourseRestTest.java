package com.example.demo.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

import static com.example.demo.model.CourseTest.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseRest.class)
public class CourseRestTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CourseService courseService;

    @Test
    public void getCourseById() throws Exception {
        Course course = new Course(DFT_ID, DFT_LIBELLE, DFT_ECTS, DFT_ETUDIANTS);
        Mockito.when(courseService.getCourseById(DFT_ID)).thenReturn(Optional.of(course));
        mvc.perform(get("/api/getCourses/" + DFT_ID))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(DFT_ID));
    }
}