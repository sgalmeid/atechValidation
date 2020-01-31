package br.com.atech.test.pilotservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@Getter
public class Adrress {
    private String cityName;
    private String street;

    public Adrress(){}

}
