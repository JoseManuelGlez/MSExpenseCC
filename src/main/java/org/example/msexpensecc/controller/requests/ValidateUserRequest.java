package org.example.msexpensecc.controller.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ValidateUserRequest {
    private String email;
    private String password;
}
