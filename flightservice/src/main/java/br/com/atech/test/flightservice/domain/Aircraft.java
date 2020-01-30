package br.com.atech.test.flightservice.domain;

import br.com.atech.test.flightservice.infra.dto.AircraftDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@AllArgsConstructor
public class Aircraft {
    private Long id;
    private String name;

    public Aircraft(AircraftDto aircraft) {
        this(aircraft.getId(), aircraft.getName());
    }
}
