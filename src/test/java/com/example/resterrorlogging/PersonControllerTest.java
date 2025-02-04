package com.example.resterrorlogging;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testReceivePerson() throws Exception {
        // Load JSON data from a file
        Path path = ResourceUtils.getFile("classpath:example_person.json").toPath();
        String personJson = Files.readString(path);

        // Perform POST request with JSON data
        mockMvc.perform(post("/api/person")
                .contentType("application/json")
                .content(personJson))
                .andExpect(status().isOk()) // Check for 200 OK Status
                .andExpect(content().string("Person data received successfully!")); // Check for response message
    }
}