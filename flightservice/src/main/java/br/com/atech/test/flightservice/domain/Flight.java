package br.com.atech.test.flightservice.domain;

import br.com.atech.test.flightservice.infra.dto.form.FlightFormDto;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, insertable = false, updatable = false)
    private Long id;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "departureCityId"))
    @AttributeOverride(name = "name", column = @Column(name = "departureCityName"))
    private City departureCity;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "arrivalId"))
    @AttributeOverride(name = "name", column = @Column(name = "arrivalName"))
    private City arrivalCity;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "aircraftId"))
    @AttributeOverride(name = "name", column = @Column(name = "aircraftName"))
    private Aircraft aircraft;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "pilotId"))
    @AttributeOverride(name = "name", column = @Column(name = "pilotName"))
    private Pilot pilot;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;


    public Flight(){}

    @Builder
    public Flight(LocalDateTime departureTime, LocalDateTime arrivalTime,
                  City departureCity, City arrivalCity, Aircraft aircraft,
                  Pilot pilot) {
        this.status = FlightStatus.WAITING;

        update(departureTime, arrivalTime, departureCity, arrivalCity, aircraft, pilot);
    }

    public Flight(FlightFormDto flightFormDto) {
        this(flightFormDto.getDepartureTime(),
                flightFormDto.getArrivalTime(),
                new City(flightFormDto.getDepartureCity()),
                new City(flightFormDto.getArrivalCity()),
                new Aircraft(flightFormDto.getAircraft()),
                new Pilot(flightFormDto.getPilot()));
    }

    private void update(LocalDateTime departureTime, LocalDateTime arrivalTime,
                        City departureCity, City arrivalCity, Aircraft aircraft,
                        Pilot pilot) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.aircraft = aircraft;
        this.pilot = pilot;
    }

    public void updateStatus(FlightStatus newStatus) {
        status = status.canGoTo(newStatus);
    }




}
