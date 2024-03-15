package com.example.travel.TravelSystemDesign.Factory;

import com.example.travel.TravelSystemDesign.Enums.PassengerType;
import com.example.travel.TravelSystemDesign.Model.Passenger.GoldPassenger;
import com.example.travel.TravelSystemDesign.Model.Passenger.Passenger;
import com.example.travel.TravelSystemDesign.Model.Passenger.PremiumPassenger;
import com.example.travel.TravelSystemDesign.Model.Passenger.StandardPassenger;

public class PassengerFactory {
    public Passenger getPassengerObject(PassengerType type, String name, int passengerNumber, Double balance) {
        return switch (type){
            case STANDARD -> new StandardPassenger(name, passengerNumber, balance);
            case GOLD -> new GoldPassenger(name, passengerNumber, balance);
            case PREMIUM -> new PremiumPassenger(name, passengerNumber);
            default -> throw new IllegalArgumentException("Invalid passenger type: " + type);
        };
    }

}
