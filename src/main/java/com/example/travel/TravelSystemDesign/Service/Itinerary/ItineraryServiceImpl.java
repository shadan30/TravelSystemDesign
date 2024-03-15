package com.example.travel.TravelSystemDesign.Service.Itinerary;

import com.example.travel.TravelSystemDesign.Helper.ItineraryHelper.ItineraryHelper;
import com.example.travel.TravelSystemDesign.Model.TravelPackage;
import com.example.travel.TravelSystemDesign.Response.PackageDetails;
// Generates the itinerary list of
// travel package including destinations
// and the activities in it.
public class ItineraryServiceImpl implements ItineraryService{
    private final ItineraryHelper itineraryHelper;

    public ItineraryServiceImpl(ItineraryHelper itineraryHelper) {
        this.itineraryHelper = itineraryHelper;
    }

    /**
     * Prints list of all destination (itinerary) in travel package
     * @param travelPackage
     * @return
     */
    @Override
    public PackageDetails getItinerary(TravelPackage travelPackage){
        PackageDetails packageDetails=PackageDetails.builder()
                .packageName(travelPackage.getName())
                .destinations(travelPackage.getItinerary())
                .build();
        itineraryHelper.printItinerary(packageDetails);
        return packageDetails;
    }
}
