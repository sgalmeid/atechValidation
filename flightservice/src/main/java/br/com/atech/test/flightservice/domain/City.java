package br.com.atech.test.flightservice.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class City {
    private Long id;
    private String name;
}
