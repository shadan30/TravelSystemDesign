package com.example.travel.TravelSystemDesign.Service.Itinerary;

import com.example.travel.TravelSystemDesign.Model.TravelPackage;
import com.example.travel.TravelSystemDesign.Response.PackageDetails;

public interface ItineraryService {
    PackageDetails getItinerary(TravelPackage travelPackage);
}
