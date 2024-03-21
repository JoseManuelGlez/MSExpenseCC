package org.example.msexpensecc.controller.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateExpenseRequest {
    private Double mount;
    private String category;
    private String date;
    private String description;
}
