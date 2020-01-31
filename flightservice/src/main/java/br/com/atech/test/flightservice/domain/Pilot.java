package br.com.atech.test.flightservice.domain;

import br.com.atech.test.flightservice.infra.dto.PilotDtoLite;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@AllArgsConstructor
public class Pilot {
    private Long id;
    private String name;

    public Pilot(){}

    public Pilot(PilotDtoLite pilot) {
        this(pilot.getId(),pilot.getName());
    }
}
