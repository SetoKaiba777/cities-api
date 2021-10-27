package com.kaibacorp.citiesapi.Cities.API.Controller;

import com.kaibacorp.citiesapi.Cities.API.Response.CityResponse;
import com.kaibacorp.citiesapi.Cities.Domain.Service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.kaibacorp.citiesapi.Cities.API.Conversion.CityConversor.toResponse;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityResource{

    private CityService cityServiceService;

    @GetMapping
    public Page<CityResponse> findCities(Pageable page){return toResponse(cityServiceService.findAll(page),page);}

    @GetMapping("/{id}")
    public CityResponse find(@PathVariable Long id){
        return toResponse(cityServiceService.findId(id));
    }
}