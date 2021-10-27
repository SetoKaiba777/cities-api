package com.kaibacorp.citiesapi.States.Domain.Service;

import com.kaibacorp.citiesapi.Exception.Exception.DontFoundEntityException;
import com.kaibacorp.citiesapi.States.Domain.Entity.State;
import com.kaibacorp.citiesapi.States.Domain.Repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class StateService {

    private StateRepository stateRepository;

    public Page<State> findAll(Pageable page){
        return stateRepository.findAll(page);
    }
    public State findId(Long id){
        return stateRepository.findById(id).
                orElseThrow(()->new DontFoundEntityException("State don't found"));
    }
}
