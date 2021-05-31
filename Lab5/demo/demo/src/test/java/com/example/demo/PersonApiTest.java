package com.example.demo;

import com.example.demo.contract.Person;
import com.example.demo.repositories.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest()
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtests.properties")
public class PersonApiTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PersonRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void save_test()throws Exception{

        Person p = new Person();
        p.setName("jan");
        p.setSurname("kowalski");
        mvc.perform(post("/people")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(p)))
                .andExpect(status().is(201));

    }

    @Test
    public void get_by_id_test() throws Exception{

        mvc.perform(MockMvcRequestBuilders.get("/people/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("jan"));

    }
}
