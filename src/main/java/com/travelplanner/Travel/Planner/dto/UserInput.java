package com.travelplanner.Travel.Planner.dto;

import lombok.Data;

@Data
public class UserInput
{
    private int budget;
    private int days;
    private int people;
    private String season;
}
