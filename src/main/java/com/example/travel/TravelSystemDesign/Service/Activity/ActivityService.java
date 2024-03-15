package com.example.travel.TravelSystemDesign.Service.Activity;

import com.example.travel.TravelSystemDesign.Model.TravelPackage;
import com.example.travel.TravelSystemDesign.Response.ActivityDetails;

import java.util.List;

public interface ActivityService {
    List<ActivityDetails> getAllActivities(TravelPackage travelPackage);
}
