package com.kaibacorp.citiesapi.Countries.Domain.Service;

import com.kaibacorp.citiesapi.Countries.Domain.Entity.Country;
import com.kaibacorp.citiesapi.Countries.Domain.Repository.CountryRepository;
import com.kaibacorp.citiesapi.Exception.Exception.DontFoundEntityException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class CountryService {

    private CountryRepository countryRepository;

    public Page<Country> findAll(Pageable page){
        return countryRepository.findAll(page);
    }
    public Country findId(Long id){
        return countryRepository.findById(id).
                orElseThrow(()->new DontFoundEntityException("Country don't found"));
    }
}
