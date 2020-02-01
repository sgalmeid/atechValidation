package br.com.atech.test.flightservice.infra.dto.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class FlightFormDto {
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm")
    private LocalDateTime departureTime;
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm")
    private LocalDateTime arrivalTime;
    private long departureCity;
    private long arrivalCity;
    private long aircraft;
    private long pilot;
}
