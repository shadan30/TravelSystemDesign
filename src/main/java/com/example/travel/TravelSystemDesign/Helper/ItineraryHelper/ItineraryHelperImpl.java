package com.example.travel.TravelSystemDesign.Helper.ItineraryHelper;

import com.example.travel.TravelSystemDesign.Model.Activity;
import com.example.travel.TravelSystemDesign.Model.Destination;
import com.example.travel.TravelSystemDesign.Response.PackageDetails;

public class ItineraryHelperImpl implements ItineraryHelper{
    /**
     * Prints out Package Details
     * along with destination and activity details
     * @param packageList
     */
    @Override
    public void printItinerary(PackageDetails packageList) {
        System.out.println("Package Name : "+packageList.getPackageName());
        for(Destination destination:packageList.getDestinations()){
            System.out.println("Destination Name : "+destination.getName());
            for(Activity activity:destination.getActivities()){
                System.out.println(activity);
            }
        }
    }
}
