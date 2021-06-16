package com.example.demo;

import com.example.demo.contract.AccidentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Calendar;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtests.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccidentsTest extends CarApiTestBase{

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;
    BasicJsonTester json = new BasicJsonTester(getClass()) ;

    @Test
    @Order(1)
    public void cars_test() throws Exception {
        testPostMethod();
    }

    @Test
    @Order(2)
    public void addAccidentTest() throws Exception {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2000,0,1);
        AccidentDto january = new AccidentDto("wypadek1", calendar.getTime(), "A1", "B1");
        calendar.add(Calendar.MONTH, 1);
        AccidentDto february = new AccidentDto("wypadek2", calendar.getTime(), "A2", "B2");
        calendar.add(Calendar.MONTH, 1);
        AccidentDto march = new AccidentDto("wypadek3", calendar.getTime(), "A3", "B3");


        mvc.perform(post("/cars/100/accidents")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(january)))
                .andExpect(status().isNotFound());

        mvc.perform(post("/cars/1/accidents")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(january)))
                .andExpect(status().isNoContent());

        mvc.perform(post("/cars/1/accidents")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(february)))
                .andExpect(status().isNoContent());
        mvc.perform(post("/cars/1/accidents")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(march)))
                .andExpect(status().isNoContent());

    }

    @Test
    @Order(3)
    public void getCarAccidentsTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/cars/1/accidents").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").value("wypadek1"))
                .andExpect(jsonPath("$[0].culprit").value("A1"))
                .andExpect(jsonPath("$[0].sufferer").value("B1"))
                .andExpect(jsonPath("$[0].date").value(Matchers.containsString("2000-01")))
                .andExpect(jsonPath("$[1].description").value("wypadek2"))
                .andExpect(jsonPath("$[1].culprit").value("A2"))
                .andExpect(jsonPath("$[1].sufferer").value("B2"))
                .andExpect(jsonPath("$[1].date").value(Matchers.containsString("2000-02")))
                .andExpect(jsonPath("$[2].description").value("wypadek3"))
                .andExpect(jsonPath("$[2].culprit").value("A3"))
                .andExpect(jsonPath("$[2].sufferer").value("B3"))
                .andExpect(jsonPath("$[2].date").value(Matchers.containsString("2000-03")));
    }

    @Test
    @Order(4)
    public void getCarAccidentsByIdTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/cars/1/accidents/3").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("wypadek3"))
                .andExpect(jsonPath("$.culprit").value("A3"))
                .andExpect(jsonPath("$.sufferer").value("B3"))
                .andExpect(jsonPath("$.date").value(Matchers.containsString("2000-03")));


        mvc.perform(MockMvcRequestBuilders.get("/cars/1/accidents/30").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(5)
    public void deleteAccidentTest() throws Exception {

        mvc.perform(delete("/cars/1/accidents/1")).andExpect(status().isNoContent());
        mvc.perform(delete("/cars/1/accidents/1")).andExpect(status().isNotFound());
    }

    @Test
    @Order(6)
    public void updateAccidentTest() throws Exception {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2000,1,1);
        AccidentDto accident = new AccidentDto("nowy wypadek", calendar.getTime(), "A3", "B3");

        mvc.perform(put("/cars/1/accidents/3")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(accident)))
                .andExpect(status().isOk())
        ;

        mvc.perform(put("/cars/1/accidents/30")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(accident)))
                .andExpect(status().isNotFound())
        ;

        mvc.perform(MockMvcRequestBuilders.get("/cars/1/accidents/3").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("nowy wypadek"));
    }

}
