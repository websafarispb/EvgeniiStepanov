package ru.stepev.test.training.at.hw5.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.stepev.test.training.at.hw5.model.component.Role;

@Data
@AllArgsConstructor
@Builder
public class User {

    private Integer id;
    private String name;
    private String password;
    private Role role;
}
