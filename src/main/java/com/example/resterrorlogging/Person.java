package com.example.resterrorlogging;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Person {

    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Age cannot be null")
    @Positive(message = "Age should be a positive number")
    private Integer age;
}
