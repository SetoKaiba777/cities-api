package com.kaibacorp.citiesapi.Cities.API.Controller;


import com.kaibacorp.citiesapi.Cities.API.Response.DistanceResponse;
import com.kaibacorp.citiesapi.Cities.Domain.Service.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResource {


    @Autowired
    private DistanceService distanceService;
    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    public DistanceResource(DistanceService service) {
        this.distanceService = service;
    }


    @GetMapping("/by-points")
    public DistanceResponse calculateByPoints(@RequestParam(name = "from") final Long city1,
                                     @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return distanceService.distanceByPointsInMiles(city1, city2);
    }

    @GetMapping("/by-cube")
    public DistanceResponse  calculateByCube(@RequestParam(name = "from") final Long city1,
                                   @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return distanceService.distanceByCubeInMeters(city1, city2);
    }

}