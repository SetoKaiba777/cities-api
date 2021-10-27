package com.kaibacorp.citiesapi.States.API.Conversion;

import com.kaibacorp.citiesapi.Countries.API.Response.CountryResponse;
import com.kaibacorp.citiesapi.Countries.Domain.Entity.Country;
import com.kaibacorp.citiesapi.States.API.Response.StateResponse;
import com.kaibacorp.citiesapi.States.Domain.Entity.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public class StateConversor {

    public static StateResponse toResponse(State state){
        StateResponse stateRp = new StateResponse();
        stateRp.setId(state.getId());
        stateRp.setDdd(state.getDdd());
        stateRp.setIbge(state.getIbge());
        stateRp.setUf(state.getUf());
        stateRp.setName(state.getName());
        return stateRp;
    }
    public static Page<StateResponse> toResponse(Page<State> states, Pageable page) {
        var statesRP = new ArrayList<StateResponse>();
        for (State state : states) {
            StateResponse stateRp = new StateResponse();
            stateRp.setId(state.getId());
            stateRp.setDdd(state.getDdd());
            stateRp.setIbge(state.getIbge());
            stateRp.setUf(state.getUf());
            stateRp.setName(state.getName());
            statesRP.add(stateRp);
        }
        return new PageImpl<>(statesRP, page, statesRP.size());
    }
}
