package com.example.travel.TravelSystemDesign.Service.Passenger.Signup;

import com.example.travel.TravelSystemDesign.Exceptions.ActivityNotPresent;
import com.example.travel.TravelSystemDesign.Model.Passenger.Passenger;
import com.example.travel.TravelSystemDesign.Model.TravelPackage;

public interface PassengerSignupService {
    public void passengerSignUp(Passenger passenger, TravelPackage travelPackage, String activityName) throws ActivityNotPresent;
}
