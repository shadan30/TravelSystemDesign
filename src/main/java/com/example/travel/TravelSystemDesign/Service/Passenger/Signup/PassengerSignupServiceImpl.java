package com.example.travel.TravelSystemDesign.Service.Passenger.Signup;

import com.example.travel.TravelSystemDesign.Enums.PassengerType;
import com.example.travel.TravelSystemDesign.Exceptions.ActivityFullException;
import com.example.travel.TravelSystemDesign.Exceptions.ActivityNotPresent;
import com.example.travel.TravelSystemDesign.Factory.PassengerFactory;
import com.example.travel.TravelSystemDesign.Model.Activity;
import com.example.travel.TravelSystemDesign.Model.Destination;
import com.example.travel.TravelSystemDesign.Model.Passenger.Passenger;
import com.example.travel.TravelSystemDesign.Model.PassengerActivity;
import com.example.travel.TravelSystemDesign.Model.TravelPackage;

import java.util.List;

public class PassengerSignupServiceImpl implements PassengerSignupService{
    private final PassengerFactory passengerFactory;

    public PassengerSignupServiceImpl(PassengerFactory passengerFactory) {
        this.passengerFactory = passengerFactory;
    }

    /**
     * Helps to sign up a user for an
     * activity and also updates balance
     * according to the category passenger
     * belongs to.
     * @param passenger
     * @param travelPackage
     * @param activityName
     */
    @Override
    public void passengerSignUp(Passenger passenger, TravelPackage travelPackage, String activityName) throws ActivityNotPresent {
        boolean isPresent=false;
        List<Destination> destinationList = travelPackage.getItinerary();
        Passenger passengerObject = passengerFactory.getPassengerObject(PassengerType.valueOf(passenger.getPassengerType()),
                passenger.getName(),passenger.getNumber(),passenger.getBalance());
        for(Destination destination:destinationList){
            List<Activity> activities = destination.getActivities();
            for(Activity activity:activities){
                if(activityName.equals(activity.getName())){
                    try {
                        if(activity.getCapacity() == 0) {
                            throw new ActivityFullException("Activity is at Capacity");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    List<PassengerActivity> activityPassengers = passenger.getActivities();
                    try {
                        activityPassengers.add(PassengerActivity.builder()
                                .destination(destination.getName())
                                .name(activityName)
                                .price(passengerObject.updateBalance(activity))
                                .build());
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    passenger.setActivities(activityPassengers);
                    activity.reduceCapacity();
                    isPresent=true;
                    break;
                }
            }
            if(isPresent) break;
        }
        if(!isPresent) {
            throw new ActivityNotPresent("The Activity is not present");
        }
    }
}
