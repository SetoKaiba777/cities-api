package com.kaibacorp.citiesapi.States.Domain.Repository;

import com.kaibacorp.citiesapi.States.Domain.Entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State,Long> {

}
