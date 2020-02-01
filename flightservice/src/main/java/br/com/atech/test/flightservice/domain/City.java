package br.com.atech.test.flightservice.domain;

import br.com.atech.test.flightservice.infra.dto.CityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@AllArgsConstructor
public class City {
    private Long id;
    private String name;

    public City(){}

    public City(CityDto city) {
        this(city.getId(), city.getCityName());
    }
}
