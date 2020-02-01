package br.com.atech.test.cityservice.infra.dto;

import br.com.atech.test.cityservice.domain.City;
import lombok.Getter;

@Getter
public class CityDto {

    private Long id;

    private String cityName;

    public CityDto(City city){
        this.id = city.getId();
        this.cityName = String.format("%s / %s (%s)", city.getCity(), city.getState(), city.getCountry());
    }
}
