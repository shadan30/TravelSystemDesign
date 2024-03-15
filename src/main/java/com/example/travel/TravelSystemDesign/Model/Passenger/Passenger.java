package com.example.travel.TravelSystemDesign.Model.Passenger;

import com.example.travel.TravelSystemDesign.Exceptions.InsufficientBalance;
import com.example.travel.TravelSystemDesign.Model.Activity;
import com.example.travel.TravelSystemDesign.Model.PassengerActivity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Using Factory Method
 * This is a Base Passenger class
 * To reduce boilerplate code , using base passenger to encapsulate basic passenger details
 */
@Data
@NoArgsConstructor
public abstract class Passenger{
    private Integer passengerId;
    private String name;
    private int number;
    private String passengerType;
    private Double balance;
    private List<PassengerActivity> activities;
    public abstract Double updateBalance(Activity activity) throws InsufficientBalance;
    public Passenger(String name, int number,Double balance) {
        this.name = name;
        this.number = number;
        this.balance=balance;
        this.activities = new ArrayList<>();
    }
}
