package com.example.demo;

import com.example.demo.contract.Car;
import com.example.demo.contract.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CarApiTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;
    BasicJsonTester json = new BasicJsonTester(getClass()) ;

    @Test
    public void testPostMethod()throws Exception{

        Car car = new Car("BMW","GD1234",200,false,20000);

        mvc.perform(post("/cars")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isNoContent());

        mvc.perform(MockMvcRequestBuilders.get("/cars/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("BMW"))
                .andExpect(jsonPath("$.registrationNumber").value("GD1234"))
                .andExpect(jsonPath("$.milleage").value(200))
                .andExpect(jsonPath("$.hasAccidents").value(false))
                .andExpect(jsonPath("$.price").value(20000));

        Car car1 = new Car("BMW1","GD1234",200,false,20000);
        Car car2 = new Car("BMW2","GD1234",200,false,20000);
        Car car3 = new Car("BMW3","GD1234",200,false,20000);

        mvc.perform(post("/cars")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(car1)));


        mvc.perform(post("/cars")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(car2)));


        mvc.perform(post("/cars")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(car3)));

        mvc.perform(MockMvcRequestBuilders.get("/cars/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/cars/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/cars/3").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/cars/4").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/cars/40").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        mvc.perform(put("/cars/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(car3)))
                .andExpect(status().isOk())
        ;

        mvc.perform(MockMvcRequestBuilders.get("/cars/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("BMW3"));

        mvc.perform(put("/cars/60")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(car3)))
                .andExpect(status().isNotFound());


        mvc.perform(delete("/cars/1")).andExpect(status().isNoContent());
        mvc.perform(delete("/cars/1")).andExpect(status().isNotFound());
        mvc.perform(delete("/cars/2")).andExpect(status().isNoContent());
        mvc.perform(delete("/cars/2")).andExpect(status().isNotFound());
        mvc.perform(delete("/cars/3")).andExpect(status().isNoContent());
        mvc.perform(delete("/cars/3")).andExpect(status().isNotFound());
    }
}
