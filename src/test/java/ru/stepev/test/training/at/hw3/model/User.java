package ru.stepev.test.training.at.hw3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {

    private String name;
    private String password;
}
