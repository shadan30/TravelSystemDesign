package com.example.travel.TravelSystemDesign.Helper.PassengerHelper;

import com.example.travel.TravelSystemDesign.Model.PassengerActivity;
import com.example.travel.TravelSystemDesign.Response.PassengerDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassengerHelperImplTest {
    private PassengerHelperImpl passengerHelper;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        passengerHelper = new PassengerHelperImpl();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testPassengerPrinterWithPremiumPassenger() {
        PassengerActivity activity1 = new PassengerActivity("Destination 1", "Activity 1", (double)100);
        PassengerActivity activity2 = new PassengerActivity("Destination 2", "Activity 2", (double)150);

        List<PassengerActivity> activities = new ArrayList<>();
        activities.add(activity1);
        activities.add(activity2);

        PassengerDetails passengerDetails = new PassengerDetails("John Doe", 1, (double)500, activities);
        passengerHelper.passengerPrinter(passengerDetails);

        // Assert
        String expectedOutput = "Passenger Name: John Doe\n" +
                "Passenger Number: 1\n" +
                "Passenger Balance : 500.0\n" +
                "Activity Name: Activity 1\n" +
                "Destination: Destination 1\n" +
                "Price to customer: 100.0\n\n" +
                "Activity Name: Activity 2\n" +
                "Destination: Destination 2\n" +
                "Price to customer: 150.0\n\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

}