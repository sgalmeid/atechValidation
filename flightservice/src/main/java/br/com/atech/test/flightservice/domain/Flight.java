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

    private Long departurCity;
    private Long arrivalCity;
    private Long aircraft;
    private Long pilot;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    public void updateStatus(FlightStatus newStatus) {
        status = status.canGoTo(newStatus);
    }


}
