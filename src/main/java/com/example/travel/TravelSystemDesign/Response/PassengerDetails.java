package com.example.travel.TravelSystemDesign.Response;

import com.example.travel.TravelSystemDesign.Model.PassengerActivity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDetails {
    private String passengerName;
    private int passengerNumber;
    private Double balance;
    private List<PassengerActivity> passengerActivityList;
}
