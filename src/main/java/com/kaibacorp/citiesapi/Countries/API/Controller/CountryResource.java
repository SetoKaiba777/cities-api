package com.kaibacorp.citiesapi.Countries.API.Controller;

import com.kaibacorp.citiesapi.Countries.API.Response.CountryResponse;
import com.kaibacorp.citiesapi.Countries.Domain.Service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.kaibacorp.citiesapi.Countries.API.Conversion.CountryConversor.toResponse;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountryResource {

    private CountryService countryService;

    @GetMapping
    public Page<CountryResponse> findCountries(Pageable page){
        return toResponse(countryService.findAll(page),page);
    }
    @GetMapping("/{id}")
    public CountryResponse find(@PathVariable Long id){
        return toResponse(countryService.findId(id));
    }
}
