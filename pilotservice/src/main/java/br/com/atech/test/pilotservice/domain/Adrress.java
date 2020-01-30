package br.com.atech.test.pilotservice.domain;

import lombok.AllArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
public class Adrress {
    private String cityName;
    private String street;

    public Adrress(){}



}
