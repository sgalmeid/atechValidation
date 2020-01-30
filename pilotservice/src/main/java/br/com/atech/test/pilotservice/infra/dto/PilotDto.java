package br.com.atech.test.pilotservice.infra.dto;

import br.com.atech.test.pilotservice.domain.Pilot;
import lombok.Getter;

import java.util.Optional;

@Getter
public class PilotDto {

    private Long id;
    private String fisrtName;
    private String lastName;

    public PilotDto(Pilot pilot) {
        this.id = pilot.getId();
        this.fisrtName = pilot.getFisrtName();
        this.lastName = pilot.getLastName();
    }
}
