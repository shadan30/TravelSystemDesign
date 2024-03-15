package com.example.travel.TravelSystemDesign.Service.Passenger;

import com.example.travel.TravelSystemDesign.Helper.PassengerHelper.PassengerHelper;
import com.example.travel.TravelSystemDesign.Model.Passenger.Passenger;
import com.example.travel.TravelSystemDesign.Model.Passenger.StandardPassenger;
import com.example.travel.TravelSystemDesign.Model.PassengerActivity;
import com.example.travel.TravelSystemDesign.Model.TravelPackage;
import com.example.travel.TravelSystemDesign.Response.PassengerDetails;
import com.example.travel.TravelSystemDesign.Response.PassengerListDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class PassengerServiceImplTest {

    @Mock
    private PassengerHelper passengerHelper;

    private PassengerServiceImpl passengerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        passengerService = new PassengerServiceImpl(passengerHelper);
    }

    @Test
    public void testGetPassenger() {
        TravelPackage travelPackage = createTravelPackage();
        Passenger passenger = travelPackage.getPassengers().get(0);
        int passengerId = passenger.getPassengerId();
        PassengerDetails expectedPassengerDetails = createPassengerDetails(passenger);

        PassengerDetails result = passengerService.getPassenger(travelPackage, passengerId);
        // Assert
        assertEquals(expectedPassengerDetails, result);
        verify(passengerHelper).passengerPrinter(expectedPassengerDetails);
    }

    @Test
    public void testGetAllPassengers() {
        TravelPackage travelPackage = createTravelPackage();
        PassengerListDetails expectedListDetails = PassengerListDetails.builder()
                .packageName(travelPackage.getName())
                .packageCapacity(travelPackage.getCapacity())
                .passengerCount(travelPackage.getPassengers().size())
                .passengerList(travelPackage.getPassengers())
                .build();
        PassengerListDetails result = passengerService.getAllPassengers(travelPackage);

        assertEquals(expectedListDetails, result);
    }

    private TravelPackage createTravelPackage() {
        List<Passenger> passengers = new ArrayList<>();
        Passenger passenger1=new StandardPassenger("Passenger 1", 1, 1000.0);
        passenger1.setPassengerId(1);
        Passenger passenger2=new StandardPassenger("Passenger 2", 2, 1500.0);
        passenger2.setPassengerId(2);
        passengers.add(passenger1);
        passengers.add(passenger2);
        return TravelPackage.builder()
                .name("Test package")
                .itinerary(new ArrayList<>())
                .passengers(passengers).build();
    }

    private PassengerDetails createPassengerDetails(Passenger passenger) {
        Double balance = passenger.getBalance();
        if (balance == -1) {
            balance = (double) -1;
        } else {
            for (PassengerActivity activity : passenger.getActivities()) {
                balance -= activity.getPrice();
            }
        }
        return PassengerDetails.builder()
                .passengerName(passenger.getName())
                .passengerNumber(passenger.getNumber())
                .balance(balance)
                .passengerActivityList(passenger.getActivities())
                .build();
    }
}