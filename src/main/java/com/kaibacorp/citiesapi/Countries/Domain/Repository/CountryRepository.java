package com.kaibacorp.citiesapi.Countries.Domain.Repository;

import com.kaibacorp.citiesapi.Countries.Domain.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {

}
