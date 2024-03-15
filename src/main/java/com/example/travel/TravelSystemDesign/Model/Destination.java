package com.example.travel.TravelSystemDesign.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Destination {
    private String destinationId;
    private String name;
    private List<Activity> activities;
}
