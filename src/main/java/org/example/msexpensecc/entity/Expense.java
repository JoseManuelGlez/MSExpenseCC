package org.example.msexpensecc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "expenses")
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Double mount;
    private String category;
    private String date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
