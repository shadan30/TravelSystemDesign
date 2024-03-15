package com.example.travel.TravelSystemDesign.Service.Activity;

import com.example.travel.TravelSystemDesign.Enums.PassengerType;
import com.example.travel.TravelSystemDesign.Helper.ActivityHelper.ActivityHelper;
import com.example.travel.TravelSystemDesign.Model.Activity;
import com.example.travel.TravelSystemDesign.Model.Destination;
import com.example.travel.TravelSystemDesign.Model.Passenger.Passenger;
import com.example.travel.TravelSystemDesign.Model.Passenger.StandardPassenger;
import com.example.travel.TravelSystemDesign.Model.PassengerActivity;
import com.example.travel.TravelSystemDesign.Model.TravelPackage;
import com.example.travel.TravelSystemDesign.Response.ActivityDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class ActivityServiceImplTest {

    @Mock
    private ActivityHelper activityHelper;

    private ActivityServiceImpl activityService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        activityService = new ActivityServiceImpl(activityHelper);
    }

    @Test
    public void testGetAllActivities_WithAvailableSpaces() {
        TravelPackage travelPackage = createTravelPackageWithSpaces();
        List<ActivityDetails> expectedActivities = Arrays.asList(
                new ActivityDetails(Activity.builder().name("Activity 2").cost(150.0).capacity(20).build(), 20),
                new ActivityDetails(Activity.builder().name("Activity 1").cost(100.0).capacity(10).build(), 10)
        );
        List<ActivityDetails> result = activityService.getAllActivities(travelPackage);
        // Assert
        assertEquals(expectedActivities, result);
        verify(activityHelper).printActivities(expectedActivities);
    }

    @Test
    public void testGetAllActivities_WithNoAvailableSpaces() {
        TravelPackage travelPackage = createTravelPackageWithNoSpaces();
        List<ActivityDetails> result = activityService.getAllActivities(travelPackage);

        assertEquals(0, result.size());
        verify(activityHelper).printActivities(Collections.emptyList());
    }

    private TravelPackage createTravelPackageWithSpaces() {
        List<Destination> destinations = new ArrayList<>();
        List<Activity> activities1 = Arrays.asList(Activity.builder().name("Activity 1").cost(100.0).capacity(10).build());
        List<Activity> activities2 = Arrays.asList(Activity.builder().name("Activity 2").cost(150.0).capacity(20).build());
        destinations.add(new Destination("1","Destination 1", activities1));
        destinations.add(new Destination("2","Destination 2", activities2));
        Passenger passenger1=new StandardPassenger("Passenger 1", 1, 1000.0);
        passenger1.setPassengerType(PassengerType.STANDARD.name());
        Passenger passenger2=new StandardPassenger("Passenger 2", 2, 1500.0);
        passenger2.setPassengerType(PassengerType.STANDARD.name());
        List<Passenger> passengers = Arrays.asList(
                passenger1,passenger2
        );
        return TravelPackage.builder().name("Test Package").itinerary(destinations).passengers(passengers).build();
    }

    private TravelPackage createTravelPackageWithNoSpaces() {
        List<Destination> destinations = new ArrayList<>();
        Activity.builder().name("Activity 1").cost(100.0).capacity(0).build();
        List<Activity> activities = Arrays.asList(Activity.builder().name("Activity 1").cost(100.0).capacity(0).build());
        destinations.add(new Destination("1","Destination 1", activities));
        Passenger passenger=new StandardPassenger("Passenger 1", 1, 1000.0);
        passenger.setPassengerType(PassengerType.STANDARD.name());
        List<Passenger> passengers = Collections.singletonList(
                passenger
        );
        return TravelPackage.builder().name("Test Package").itinerary(destinations).passengers(passengers).build();
    }
}
