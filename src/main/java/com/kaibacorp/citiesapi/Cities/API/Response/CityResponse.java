package com.kaibacorp.citiesapi.Cities.API.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class CityResponse {
    private long id;
    private String name;
    private Integer uf;
    private String geolocation;

    public CityResponse(){}

    public CityResponse(long id, String name, Integer uf, String geolocation){
        this.id = id;
        this.name = name;
        this.uf = uf;
        this.geolocation = geolocation;
    }
}
