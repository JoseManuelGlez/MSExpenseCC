package org.example.msexpensecc.controller.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateExpenseResponse {
    private String id;
    private Double mount;
    private String category;
    private String date;
    private String description;
}
