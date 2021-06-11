package com.example.demo;

import com.example.demo.contract.PersonDto;
import com.example.demo.repositories.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest()
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtests.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonApiTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PersonRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    public void save_test()throws Exception{

        PersonDto p = new PersonDto();
        p.setName("jan");
        p.setSurname("kowalski");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000,2,1);
        p.setBirthday(calendar.getTime());
        mvc.perform(post("/people")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(p)))
                .andExpect(status().is(201));

    }

    @Test
    public void get_by_id_test() throws Exception{

        mvc.perform(MockMvcRequestBuilders.get("/people/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("jan"))
                .andExpect(jsonPath("$.birthday").value(Matchers.containsString("2000-02")));

    }

    @Test
    public void get_all_test() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/people").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("jan"));
    }
}
