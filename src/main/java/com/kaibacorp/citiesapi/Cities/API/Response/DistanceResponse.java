package com.kaibacorp.citiesapi.Cities.API.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistanceResponse {

    private String from;
    private String to;
    private double distance;
    private String unit;

    public DistanceResponse(String from,String to, double distance, String unit){
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.unit = unit;
    }

}
