package com.kaibacorp.citiesapi.Cities.Domain.Service;

import com.kaibacorp.citiesapi.Cities.Domain.Entity.City;
import com.kaibacorp.citiesapi.Cities.Domain.Repository.CityRepository;
import com.kaibacorp.citiesapi.Exception.Exception.DontFoundEntityException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class CityService {

    private CityRepository cityRepository;

    public Page<City> findAll(Pageable page){
        return cityRepository.findAll(page);
    }
    public City findId(Long id){
        return cityRepository.findById(id).
                orElseThrow(()->new DontFoundEntityException("City don't found"));
    }
}
