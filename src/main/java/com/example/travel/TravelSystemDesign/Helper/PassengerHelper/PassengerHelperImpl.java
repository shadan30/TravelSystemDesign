package com.example.travel.TravelSystemDesign.Helper.PassengerHelper;

import com.example.travel.TravelSystemDesign.Model.Passenger.Passenger;
import com.example.travel.TravelSystemDesign.Model.PassengerActivity;
import com.example.travel.TravelSystemDesign.Response.PassengerDetails;
import com.example.travel.TravelSystemDesign.Response.PassengerListDetails;

public class PassengerHelperImpl implements PassengerHelper {
    /**
     * Prints out Details of Single Passenger
     * along with activities they have subscribed
     *
     * @param passengerResult
     */
    @Override
    public void passengerPrinter(PassengerDetails passengerResult) {
        System.out.println("Passenger Name: " + passengerResult.getPassengerName()
                + "\nPassenger Number: " + passengerResult.getPassengerNumber());
        if (passengerResult.getBalance() == -1) {
            System.out.println("Premium Passenger's Balance is not applicable ");
        } else {
            System.out.println("Passenger Balance : " + passengerResult.getBalance());
        }
        for (PassengerActivity passengerActivity : passengerResult.getPassengerActivityList()) {
            System.out.println("Activity Name: " + passengerActivity.getName()
                    + "\nDestination: " + passengerActivity.getDestination()
                    + "\nPrice to customer: " + passengerActivity.getPrice() + "\n");
        }
    }

    /**
     * Prints out list of passengers in the travel package in detail.
     * @param passengerList
     */
    @Override
    public void allPassengersPrinter(PassengerListDetails passengerList) {
        System.out.println("Package Name: " + passengerList.getPackageName()
                + "\nPassenger Capacity: " + passengerList.getPackageCapacity()
                + "\nPassengers Count: " + passengerList.getPassengerCount());
        for (Passenger passenger : passengerList.getPassengerList()) {
            System.out.println("Passenger Name: " + passenger.getName()
                    + "\nPassenger Number: " + passenger.getNumber());
        }
    }
}
