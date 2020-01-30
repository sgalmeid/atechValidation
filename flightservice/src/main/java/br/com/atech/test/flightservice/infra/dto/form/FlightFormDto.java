package br.com.atech.test.flightservice.infra.dto.form;

import br.com.atech.test.flightservice.domain.FlightStatus;
import br.com.atech.test.flightservice.infra.dto.AircraftDto;
import br.com.atech.test.flightservice.infra.dto.CityDto;
import br.com.atech.test.flightservice.infra.dto.PilotDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class FlightFormDto {
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private CityDto departureCity;
    private CityDto arrivalCity;
    private AircraftDto aircraft;
    private PilotDto pilot;
}
