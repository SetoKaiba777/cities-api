package com.kaibacorp.citiesapi.Countries.Domain.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name="pais")
public class Country {

    @Id
    private Long id;

    @Column(name="nome")
    private String name;

    @Column(name="nome_pt")
    private String portugueseName;

    @Column(name="sigla")
    private String code;

    private Integer bacen;

    public Country(){

    }

}
