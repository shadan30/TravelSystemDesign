package com.example.travel.TravelSystemDesign.Service.Activity;

import com.example.travel.TravelSystemDesign.Helper.ActivityHelper.ActivityHelper;
import com.example.travel.TravelSystemDesign.Model.Activity;
import com.example.travel.TravelSystemDesign.Model.Destination;
import com.example.travel.TravelSystemDesign.Model.Passenger.Passenger;
import com.example.travel.TravelSystemDesign.Model.PassengerActivity;
import com.example.travel.TravelSystemDesign.Model.TravelPackage;
import com.example.travel.TravelSystemDesign.Response.ActivityDetails;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityServiceImpl implements ActivityService{

    private final ActivityHelper activityHelper;
    public ActivityServiceImpl(ActivityHelper activityHelper) {
        this.activityHelper=activityHelper;
    }

    /**
     * This method will calculate the number of
     * activities that still have spaces
     * and number of vacant spaces.
     * @param travelPackage
     * @return
     */
    @Override
    public List<ActivityDetails> getAllActivities(TravelPackage travelPackage) {
        List<ActivityDetails> listActivities = new ArrayList<>();
        Map<String,ActivityDetails> activityHashMap = new HashMap<>();
        List<Destination> destinations = travelPackage.getItinerary();
        for(Destination destination:destinations){
            List<Activity> activities = destination.getActivities();
            for(Activity activity:activities){
                activityHashMap.putIfAbsent(activity.getName(),
                        ActivityDetails.builder()
                        .activity(activity).vacantSpace(activity.getCapacity())
                        .build());

            }
        }
        List<Passenger> passengers = travelPackage.getPassengers();
        for(Passenger passenger:passengers){
            List<PassengerActivity> passengerActivities=passenger.getActivities();
            for(PassengerActivity passengerActivity:passengerActivities){
                ActivityDetails activityList = activityHashMap.get(passengerActivity.getName());
                activityList.reduceVacantSeats();
                activityHashMap.put(passengerActivity.getName(),activityList);
            }
        }
        for(String activityName:activityHashMap.keySet()){
            ActivityDetails activityDetails = activityHashMap.get(activityName);
            if(activityDetails.getVacantSpace()>0)
                listActivities.add(activityDetails);
        }
        activityHelper.printActivities(listActivities);
        return listActivities;
    }
}
