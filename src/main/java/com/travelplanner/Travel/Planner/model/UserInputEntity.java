package com.travelplanner.Travel.Planner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserInputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int budget;
    private int days;
    private int people;
    private String season;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
