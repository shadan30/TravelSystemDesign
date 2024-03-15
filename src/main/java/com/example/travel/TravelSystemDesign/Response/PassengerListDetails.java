package com.example.travel.TravelSystemDesign.Response;

import com.example.travel.TravelSystemDesign.Model.Passenger.Passenger;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class PassengerListDetails {
    private String packageName;
    private Integer packageCapacity;
    private Integer passengerCount;
    private List<Passenger> passengerList;
}
