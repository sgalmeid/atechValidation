package br.com.atech.test.flightservice.infra.dto.form;

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
    private long departureCity;
    private long arrivalCity;
    private long aircraft;
    private long pilot;
}
