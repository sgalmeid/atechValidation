package br.com.atech.test.flightservice.infra.util;

import br.com.atech.test.flightservice.domain.Aircraft;
import br.com.atech.test.flightservice.domain.City;
import br.com.atech.test.flightservice.domain.Flight;
import br.com.atech.test.flightservice.domain.Pilot;
import br.com.atech.test.flightservice.infra.dto.form.FlightFormDto;

import java.time.LocalDateTime;

public class DataCreator {

    public static FlightFormDto getFlightFormDto(){
        return FlightFormDto.builder()
                .aircraft(1L)
                .arrivalCity(1L)
                .arrivalTime(LocalDateTime.now().plusHours(13))
                .departureCity(2L)
                .departureTime(LocalDateTime.now().plusHours(2))
                .pilot(1L)
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
