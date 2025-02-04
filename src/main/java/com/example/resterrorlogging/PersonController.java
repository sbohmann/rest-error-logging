package com.example.resterrorlogging;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @PostMapping
    public ResponseEntity<String> receivePerson(@RequestBody @Valid Person person) {
        // Handle the person data (e.g., save to a database or process it)
        System.out.println("Received person: " + person);

        return new ResponseEntity<>("Person data received successfully!", HttpStatus.OK);
    }
}
