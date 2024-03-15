package com.example.travel.TravelSystemDesign.Helper.ActivityHelper;

import com.example.travel.TravelSystemDesign.Response.ActivityDetails;

import java.util.List;

public class ActivityHelperImpl implements ActivityHelper{
    /**
     * Prints out Available Activity Details with vacant space
     * @param activityLists
     */
    @Override
    public void printActivities(List<ActivityDetails> activityLists) {
        for(ActivityDetails activity:activityLists){
            System.out.println("Available Activity Details : "+activity+"\nVacant Space : "+activity.getVacantSpace());
        }
    }
}
