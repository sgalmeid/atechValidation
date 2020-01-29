package br.com.atech.test.flightservice.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @Embedded
    private City departurCity;
    @Embedded
    private City arrivalCity;
    @Embedded
    private Aircraft aircraft;
    private Pilot pilot;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    public Flight(LocalDateTime departureTime, LocalDateTime arrivalTime,
                  City departurCity, City arrivalCity, Aircraft aircraft,
                  Pilot pilot, FlightStatus status) {
        update(departureTime, arrivalTime, departurCity, arrivalCity, aircraft, pilot, status);
    }

    private void update(LocalDateTime departureTime, LocalDateTime arrivalTime,
                        City departurCity, City arrivalCity, Aircraft aircraft,
                        Pilot pilot, FlightStatus status) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departurCity = departurCity;
        this.arrivalCity = arrivalCity;
        this.aircraft = aircraft;
        this.pilot = pilot;
        this.status = status;
    }

    public void updateStatus(FlightStatus newStatus) {
        status = status.canGoTo(newStatus);
    }




}
