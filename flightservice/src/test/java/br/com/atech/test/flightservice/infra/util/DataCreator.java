package br.com.atech.test.flightservice.infra.util;

import br.com.atech.test.flightservice.domain.Aircraft;
import br.com.atech.test.flightservice.domain.City;
import br.com.atech.test.flightservice.domain.Flight;
import br.com.atech.test.flightservice.domain.Pilot;
import br.com.atech.test.flightservice.infra.dto.AircraftDto;
import br.com.atech.test.flightservice.infra.dto.CityDto;
import br.com.atech.test.flightservice.infra.dto.PilotDto;
import br.com.atech.test.flightservice.infra.dto.form.FlightFormDto;

import java.time.LocalDateTime;

public class DataCreator {

    public static FlightFormDto getFlightFormDto(){
        return FlightFormDto.builder()
                .aircraft(new AircraftDto(1L, "Emb 190"))
                .arrivalCity(new CityDto(1L, "Sao Paulo"))
                .arrivalTime(LocalDateTime.now().plusHours(13))
                .departureCity(new CityDto(2L, "Londres"))
                .departureTime(LocalDateTime.now().plusHours(2))
                .pilot(new PilotDto(1L, "Carlos"))
                .build();
    }

    public static Flight getFlight(){
        return Flight.builder()
                .aircraft(new Aircraft(1L,"Emb 190"))
                .arrivalCity(new City(1L, "Sao Paulo"))
                .arrivalTime(LocalDateTime.now().plusHours(13))
                .departureCity(new City(2L,"Londres"))
                .departureTime(LocalDateTime.now().plusHours(2))
                .pilot(new Pilot(1L, "Carlos"))
                .build();
    }
}
