package com.example.travel.TravelSystemDesign.Service.Passenger;

import com.example.travel.TravelSystemDesign.Helper.PassengerHelper.PassengerHelper;
import com.example.travel.TravelSystemDesign.Model.Passenger.Passenger;
import com.example.travel.TravelSystemDesign.Model.PassengerActivity;
import com.example.travel.TravelSystemDesign.Model.TravelPackage;
import com.example.travel.TravelSystemDesign.Response.PassengerDetails;
import com.example.travel.TravelSystemDesign.Response.PassengerListDetails;

import java.util.List;

public class PassengerServiceImpl implements PassengerService{
    private final PassengerHelper passengerHelper;

    public PassengerServiceImpl(PassengerHelper passengerHelper) {
        this.passengerHelper = passengerHelper;
    }

    /**
     * This method creates details of single passenger
     * @param travelPackage
     * @param passengerId
     * @return
     */
    @Override
    public PassengerDetails getPassenger(TravelPackage travelPackage, int passengerId) {
        PassengerDetails passengerDetails=null;
        List<Passenger> passengerList = travelPackage.getPassengers();
        for(Passenger passenger:passengerList){
            if(passengerId==passenger.getPassengerId()){
                Double balance = calculateBalance(passenger);
                passengerDetails =PassengerDetails.builder()
                        .passengerName(passenger.getName())
                        .passengerNumber(passenger.getNumber())
                        .balance(balance)
                        .passengerActivityList(passenger.getActivities()).build();

            }
        }
        passengerHelper.passengerPrinter(passengerDetails);
        return passengerDetails;
    }

    private Double calculateBalance(Passenger passenger) {
        Double balance = passenger.getBalance();
        if(balance == -1) {
            return (double)-1;
        }
        for (PassengerActivity activityPassenger : passenger.getActivities()) {
            balance -= activityPassenger.getPrice();
        }
        passenger.setBalance(balance);
        return balance;
    }

    /**
     * This method creates details of multiple passenger
     * @param travelPackage
     * @return
     */
    @Override
    public PassengerListDetails getAllPassengers(TravelPackage travelPackage) {
        return PassengerListDetails.builder()
                .packageName(travelPackage.getName())
                .packageCapacity(travelPackage.getCapacity())
                .passengerCount(travelPackage.getPassengers().size())
                .passengerList(travelPackage.getPassengers()).build();
    }
}
