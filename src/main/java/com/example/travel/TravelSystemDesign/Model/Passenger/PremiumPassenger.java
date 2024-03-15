package com.example.travel.TravelSystemDesign.Model.Passenger;

import com.example.travel.TravelSystemDesign.Model.Activity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PremiumPassenger extends Passenger{
    @Override
    public Double updateBalance(Activity activity) {
        return (double)0;
    }

    @Override
    public Double getBalance() {
        return (double)-1;
    }

    @Override
    public void setBalance(Double value) {
        System.out.println("Balance is not Applicable for Premium Passengers");
    }

    public PremiumPassenger(String name, int passengerNumber) {
        super(name,passengerNumber,(double)-1);
    }
}
