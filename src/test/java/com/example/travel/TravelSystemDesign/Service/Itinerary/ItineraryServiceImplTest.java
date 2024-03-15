package com.example.travel.TravelSystemDesign.Service.Itinerary;

import com.example.travel.TravelSystemDesign.Helper.ItineraryHelper.ItineraryHelper;
import com.example.travel.TravelSystemDesign.Model.Destination;
import com.example.travel.TravelSystemDesign.Model.TravelPackage;
import com.example.travel.TravelSystemDesign.Response.PackageDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class ItineraryServiceImplTest {

    @Mock
    private ItineraryHelper itineraryHelper;

    private ItineraryServiceImpl itineraryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        itineraryService = new ItineraryServiceImpl(itineraryHelper);
    }

    @Test
    public void testGetItinerary() {
        TravelPackage travelPackage = createTravelPackage();
        PackageDetails expectedPackageDetails = PackageDetails.builder()
                .packageName(travelPackage.getName())
                .destinations(travelPackage.getItinerary())
                .build();
        PackageDetails result = itineraryService.getItinerary(travelPackage);
        // Assert
        assertEquals(expectedPackageDetails, result);
        verify(itineraryHelper).printItinerary(expectedPackageDetails);
    }

    private TravelPackage createTravelPackage() {
        List<Destination> itinerary = new ArrayList<>();
        Destination.builder().destinationId("Destination 1").activities(new ArrayList<>()).build();
        itinerary.add(Destination.builder().destinationId("Destination 1").activities(new ArrayList<>()).build());
        itinerary.add(Destination.builder().destinationId("Destination 2").activities(new ArrayList<>()).build());
        return TravelPackage.builder().name("Test Package").itinerary(itinerary).passengers(new ArrayList<>()).build();
    }
}