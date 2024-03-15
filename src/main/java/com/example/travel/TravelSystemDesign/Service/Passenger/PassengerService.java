package com.example.travel.TravelSystemDesign.Service.Passenger;

import com.example.travel.TravelSystemDesign.Model.PassengerActivity;
import com.example.travel.TravelSystemDesign.Model.TravelPackage;
import com.example.travel.TravelSystemDesign.Response.PassengerDetails;
import com.example.travel.TravelSystemDesign.Response.PassengerListDetails;

public interface PassengerService {
    PassengerDetails getPassenger(TravelPackage travelPackage, int passengerId);
    PassengerListDetails getAllPassengers(TravelPackage travelPackage);
}
