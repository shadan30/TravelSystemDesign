package com.example.travel.TravelSystemDesign.Helper.PassengerHelper;

import com.example.travel.TravelSystemDesign.Response.PassengerDetails;
import com.example.travel.TravelSystemDesign.Response.PassengerListDetails;

public interface PassengerHelper {
    void passengerPrinter(PassengerDetails passengerResult);
    void allPassengersPrinter(PassengerListDetails passengerList);
}
