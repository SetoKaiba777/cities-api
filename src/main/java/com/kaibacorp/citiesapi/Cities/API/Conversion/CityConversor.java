package com.kaibacorp.citiesapi.Cities.API.Conversion;

import com.kaibacorp.citiesapi.Cities.API.Response.CityResponse;
import com.kaibacorp.citiesapi.Cities.Domain.Entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CityConversor {

    public static CityResponse toResponse(City city){
        CityResponse cityRp = new CityResponse();
        cityRp.setUf(city.getUf());
        cityRp.setName(city.getName());
        cityRp.setId(city.getId());
        cityRp.setGeolocation(city.getGeolocation());
        return cityRp;
    }


    public static Page<CityResponse> toResponse(Page<City> cities, Pageable page) {
        var citiesRP = new ArrayList<CityResponse>();
        for (City city : cities) {
            CityResponse cityRp = new CityResponse();
            cityRp.setUf(city.getUf());
            cityRp.setName(city.getName());
            cityRp.setId(city.getId());
            cityRp.setGeolocation(city.getGeolocation());
            citiesRP.add(cityRp);
        }
        return new PageImpl<>(citiesRP, page, citiesRP.size());
    }
}
