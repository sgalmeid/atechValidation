package br.com.atech.test.flightservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@AllArgsConstructor
public class City {
    private Long id;
    private String name;
}
