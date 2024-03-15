package com.example.travel.TravelSystemDesign.Response;

import com.example.travel.TravelSystemDesign.Model.Destination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PackageDetails {
    private String packageName;
    private List<Destination> destinations;
}
