package com.kaibacorp.citiesapi.Countries.API.Conversion;

import com.kaibacorp.citiesapi.Cities.API.Response.CityResponse;
import com.kaibacorp.citiesapi.Cities.Domain.Entity.City;
import com.kaibacorp.citiesapi.Countries.API.Response.CountryResponse;
import com.kaibacorp.citiesapi.Countries.Domain.Entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CountryConversor {

    public static CountryResponse toResponse(Country country){
        CountryResponse countryRp = new CountryResponse();
        countryRp.setId(country.getId());
        countryRp.setCode(country.getCode());
        countryRp.setPortugueseName(country.getPortugueseName());
        return countryRp;
    }
    public static Page<CountryResponse> toResponse(Page<Country> countries, Pageable page) {
        var countriesRP = new ArrayList<CountryResponse>();
        for (Country country : countries) {
            CountryResponse countryRp = new CountryResponse();
            countryRp.setId(country.getId());
            countryRp.setCode(country.getCode());
            countryRp.setPortugueseName(country.getPortugueseName());
            countriesRP.add(countryRp);
        }
        return new PageImpl<>(countriesRP, page, countriesRP.size());
    }
}
