package com.example.travel.TravelSystemDesign.Model;

import lombok.Builder;
import lombok.Data;

//Done in DTO
@Data
@Builder
public class Activity {
    private String activityId;
    private String name;
    private String description;
    private Double cost;
    private Integer capacity;
    public void reduceCapacity() {
        capacity -= 1;
    }
}
