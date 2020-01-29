package br.com.atech.test.flightservice.infra.dto;

import br.com.atech.test.flightservice.domain.Flight;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FlightDto {
    private Long id;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String departureCity;
    private String arrivalCity;
    private String aircraft;
    private String pilot;
    private String status;


    public FlightDto(Flight flight){
        id = flight.getId();
        departureTime = flight.getDepartureTime();
        arrivalTime = flight.getArrivalTime();
        departureCity = flight.getDepartureCity().getName();
        arrivalCity = flight.getArrivalCity().getName();
        aircraft = flight.getAircraft().getName();
        pilot = flight.getPilot().getName();
        status = flight.getStatus().name();
    }
}
