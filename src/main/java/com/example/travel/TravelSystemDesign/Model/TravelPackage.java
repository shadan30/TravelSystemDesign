package com.example.travel.TravelSystemDesign.Model;

import com.example.travel.TravelSystemDesign.Model.Passenger.Passenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TravelPackage {
    private String pacakageId;
    private String name;
    private Integer capacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;
    public String printItinerary() {
        return "P";
    }
    public String printPassengerList() {
        return "P";
    }
}
