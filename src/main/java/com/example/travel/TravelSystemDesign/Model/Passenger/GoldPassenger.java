package com.example.travel.TravelSystemDesign.Model.Passenger;

import com.example.travel.TravelSystemDesign.Exceptions.InsufficientBalance;
import com.example.travel.TravelSystemDesign.Model.Activity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoldPassenger extends Passenger{
    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name,passengerNumber,balance);
    }
    @Override
    public Double updateBalance(Activity activity) throws InsufficientBalance {
        Double cost = 0.9*activity.getCost();
        if(cost > super.getBalance()){
            throw new InsufficientBalance("Balance is insufficient for Processing");
        }
        super.setBalance(super.getBalance()-cost);
        return cost;
    }
}
