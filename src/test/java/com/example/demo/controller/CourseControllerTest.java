package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCoursePage() throws Exception {
        // mockMvc.perform(get("/courses"))
        //     .andExpect(status().isOk())
        //     .andExpect(view().name("Courses"))
        //     .andExpect(content().string(Matchers.containsString("Liste des cours")))
        //     .andExpect(content().string(Matchers.containsString("Ajouter un cours")));
    }
}