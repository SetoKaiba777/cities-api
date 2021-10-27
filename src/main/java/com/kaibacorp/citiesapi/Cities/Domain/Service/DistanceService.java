package com.kaibacorp.citiesapi.Cities.Domain.Service;

import java.util.ArrayList;
import java.util.List;

import com.kaibacorp.citiesapi.Cities.API.Response.DistanceResponse;
import com.kaibacorp.citiesapi.Cities.Domain.Entity.City;
import com.kaibacorp.citiesapi.Cities.Domain.Repository.CityRepository;
import com.kaibacorp.citiesapi.Exception.Exception.DontFoundEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    @Autowired
    private final CityRepository cityRepository;
    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public DistanceResponse distanceByPointsInMiles(final Long from, final Long to) {
        log.info("nativePostgresInMiles({}, {})", from, to);
        var cities = exisitsCity(from,to);
        var d = cityRepository.distanceByPoints(from, to);
        var result = new DistanceResponse(cities.get(0).getName(),cities.get(1).getName(),
                d, "Miles");
        return result;
    }

    public DistanceResponse distanceByCubeInMeters(Long from, Long to) {
        log.info("distanceByCubeInMeters({}, {})", from, to);
        final List<City> cities = exisitsCity(from,to);
        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();
        var d = cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        var result = new DistanceResponse(cities.get(0).getName(),cities.get(1).getName(),
                d, "Meters");
        return result;
    }

    private ArrayList<City> exisitsCity(Long city1, Long city2){
        ArrayList<City> cities = new ArrayList<City>();
        var c1 = cityRepository.findById(city1).
                orElseThrow(()->new DontFoundEntityException("One or more cities id are Invalid"));
        var c2 = cityRepository.findById(city2).
                orElseThrow(()->new DontFoundEntityException("One or more cities id are Invalid"));
        cities.add(c1);
        cities.add(c2);
        return cities;
    }
}