package com.kaibacorp.citiesapi.States.API.Response;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StateResponse {

    private Long id;
    private String name;
    private String uf;
    private Integer ibge;
    private List<Integer> ddd;
}
