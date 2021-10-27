package com.kaibacorp.citiesapi.Countries.API.Response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CountryResponse {

    private Long id;
    private String portugueseName;
    private String code;

    public CountryResponse(){

    }

}
