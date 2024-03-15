package com.example.travel.TravelSystemDesign.Helper.ActivityHelper;

import com.example.travel.TravelSystemDesign.Response.ActivityDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ActivityHelperImplTest {

    private ActivityHelperImpl activityHelper;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        activityHelper = new ActivityHelperImpl();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testPrintActivitiesWithNullList() {
        //Assert
        assertThrows(NullPointerException.class, () -> activityHelper.printActivities(null));
    }

    @Test
    public void testPrintActivitiesWithEmptyList() {
        List<ActivityDetails> activityList = new ArrayList<>();
        activityHelper.printActivities(activityList);
        // Assert
        assertEquals("", outputStreamCaptor.toString().trim());
    }
}