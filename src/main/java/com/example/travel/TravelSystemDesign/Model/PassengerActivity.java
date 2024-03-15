package com.example.travel.TravelSystemDesign.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PassengerActivity {
    private String destination;
    private String name;
    private Double price;
}
