package com.example.travel.TravelSystemDesign.Response;

import com.example.travel.TravelSystemDesign.Model.Activity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ActivityDetails {
    private Activity activity;
    private Integer vacantSpace;
    public void reduceVacantSeats() {
        if(vacantSpace != 0) {
            vacantSpace -= 1;
        }
    }
}
