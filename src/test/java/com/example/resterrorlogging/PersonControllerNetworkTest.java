package com.example.resterrorlogging;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerNetworkTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testInvalidAgeValidationWithNetworkCall() throws Exception {
        // Load JSON data from a file
        Path path = ResourceUtils.getFile("classpath:example_person.json").toPath();
        String personJson = Files.readString(path);

        String url = "http://localhost:" + port + "/api/person";

        // Create headers and set Content-Type to application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HTTP request
        HttpEntity<String> request = new HttpEntity<>(personJson, headers);

        // Send POST request and capture the response
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        // Validate response status
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
