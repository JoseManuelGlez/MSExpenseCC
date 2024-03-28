package org.example.msexpensecc.controller.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateUserRequest {
    private String name;
    private String email;
    private String password;
}
