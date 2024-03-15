package com.example.travel.TravelSystemDesign.Helper.ItineraryHelper;

import com.example.travel.TravelSystemDesign.Response.PackageDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ItineraryHelperImplTest {

    private ItineraryHelperImpl itineraryHelper;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        itineraryHelper = new ItineraryHelperImpl();
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    public void testPrintItineraryWithEmptyPackage() {
        PackageDetails packageDetails = new PackageDetails("Empty Package", new ArrayList<>());
        itineraryHelper.printItinerary(packageDetails);
        // Assert
        assertEquals("Package Name : Empty Package", outputStreamCaptor.toString().trim());
    }
}