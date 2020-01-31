package br.com.atech.test.pilotservice.infra.dto;

import br.com.atech.test.pilotservice.domain.Pilot;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PilotDto {

    private Long id;
    private String fisrtName;
    private String lastName;

    private LocalDate birthday;
    private String breve;

    private AdrressDto adrress;

    private String cellNumber;
    private String email;


    public PilotDto(Pilot pilot) {
        this.id = pilot.getId();
        this.fisrtName = pilot.getFisrtName();
        this.lastName = pilot.getLastName();
        this.birthday = pilot.getBirthday();
        this.breve = pilot.getBreve();
        this.adrress = AdrressDto.builder()
                .cityName(pilot.getAdrress().getCityName())
                .street(pilot.getAdrress().getStreet()).build();
        this.cellNumber = pilot.getCellNumber();
        this.email = pilot.getEmail();
    }
}
