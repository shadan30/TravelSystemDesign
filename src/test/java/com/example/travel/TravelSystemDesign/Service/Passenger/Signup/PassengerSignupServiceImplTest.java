package com.example.travel.TravelSystemDesign.Service.Passenger.Signup;

import com.example.travel.TravelSystemDesign.Enums.PassengerType;
import com.example.travel.TravelSystemDesign.Exceptions.ActivityNotPresent;
import com.example.travel.TravelSystemDesign.Factory.PassengerFactory;
import com.example.travel.TravelSystemDesign.Model.Activity;
import com.example.travel.TravelSystemDesign.Model.Destination;
import com.example.travel.TravelSystemDesign.Model.Passenger.Passenger;
import com.example.travel.TravelSystemDesign.Model.Passenger.StandardPassenger;
import com.example.travel.TravelSystemDesign.Model.TravelPackage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class PassengerSignupServiceImplTest {

    @Mock
    private PassengerFactory passengerFactory;

    private PassengerSignupServiceImpl passengerSignupService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        passengerSignupService = new PassengerSignupServiceImpl(passengerFactory);
    }

    @Test
    public void testPassengerSignUp_Successful() throws ActivityNotPresent {
        Passenger passenger = new StandardPassenger("John Doe", 1, 1000.0);
        passenger.setPassengerType(PassengerType.STANDARD.name());
        TravelPackage travelPackage = createTravelPackage();
        String activityName = "Activity 1";
        Activity activity = Activity.builder().name(activityName).cost(50.0).capacity(10).build();
        when(passengerFactory.getPassengerObject(any(), any(), anyInt(), anyDouble())).thenReturn(passenger);

        passengerSignupService.passengerSignUp(passenger, travelPackage, activityName);

        assertEquals(1, passenger.getActivities().size());
        assertEquals(activityName, passenger.getActivities().get(0).getName());
        assertEquals(travelPackage.getItinerary().get(0).getName(), passenger.getActivities().get(0).getDestination());
        assertEquals(950.0, passenger.getBalance());
    }

    @Test
    public void testPassengerSignUp_ActivityNotPresent() {
        Passenger passenger = new StandardPassenger("John Doe", 1, 1000.0);
        passenger.setPassengerType(PassengerType.STANDARD.name());
        TravelPackage travelPackage = createTravelPackage();
        String activityName = "Non-existent Activity";

        // Act & Assert
        assertThrows(ActivityNotPresent.class, () -> passengerSignupService.passengerSignUp(passenger, travelPackage, activityName));
    }

    private TravelPackage createTravelPackage() {
        List<Destination> itinerary = new ArrayList<>();
        List<Activity> activities = Collections.singletonList(Activity.builder().name("Activity 1").cost(50.0).capacity(10).build());
        itinerary.add(Destination.builder().name("Destination 1").activities(activities).build());
        TravelPackage travelPackage = TravelPackage.builder().name("Test Package").itinerary(itinerary).passengers(new ArrayList<>()).build();
        return travelPackage;
    }
}