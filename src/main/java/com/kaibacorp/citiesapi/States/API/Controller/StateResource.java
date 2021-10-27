package com.kaibacorp.citiesapi.States.API.Controller;

import com.kaibacorp.citiesapi.States.API.Response.StateResponse;
import com.kaibacorp.citiesapi.States.Domain.Entity.State;
import com.kaibacorp.citiesapi.States.Domain.Service.StateService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.kaibacorp.citiesapi.States.API.Conversion.StateConversor.toResponse;

@RestController
@RequestMapping("/states")
@AllArgsConstructor
public class StateResource {

    private StateService stateService;

    @GetMapping
    public Page<StateResponse> findStates(Pageable page){
        return toResponse(stateService.findAll(page),page);
    }
    @GetMapping("/{id}")
    public StateResponse find(@PathVariable Long id){
        return toResponse(stateService.findId(id));
    }
}
