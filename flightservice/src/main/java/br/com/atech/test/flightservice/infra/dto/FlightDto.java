package br.com.atech.test.flightservice.infra.dto;

import br.com.atech.test.flightservice.domain.Flight;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FlightDto {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm")
    private LocalDateTime departureTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
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
